package com.uxunchina.taling.antiReplay;

import com.alibaba.fastjson.JSONObject;
import com.uxunchina.taling.common.entity.DataResponse;
import com.uxunchina.taling.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 防止重复提交aop
 * @author chenfeng
 * @date 2022/03/28 18:35
 **/

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
@Configuration
public class AntiReplayAspect {

    @Resource
    private RedisUtils redisUtils;

    @Pointcut("@annotation(com.uxunchina.taling.antiReplay.EnableAntiReplay)")
    public void point() {
    }

    @Around("point()")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        EnableAntiReplay enableAntiReplay = method.getAnnotation(EnableAntiReplay.class);
        String token = request.getHeader("antiReplayToken");
        if(StringUtils.isBlank(token)){
            returnJson(response,new DataResponse().fail().message("防重放标识Token：antiReplayToken不能为空"));
            return null;
        }
        String redisKey = "ANTI_REPLAY_PREFIX:"
                .concat(token)
                .concat(getMethodSign(method, proceedingJoinPoint.getArgs()));
        String redisValue = redisKey.concat(enableAntiReplay.value()).concat("submit duplication");

        if (!redisUtils.hasKey(redisKey)) {
            //设置防重复操作限时标记（前置通知）
            redisUtils.set(redisKey, redisValue, enableAntiReplay.expireSeconds());
            try {
                //正常执行方法并返回
                //ProceedingJoinPoint类型参数可以决定是否执行目标方法，且环绕通知必须要有返回值，返回值即为目标方法的返回值
                return proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                //确保方法执行异常实时释放限时标记(异常后置通知)
                redisUtils.del(redisKey);
                throw new RuntimeException(throwable);
            }
        } else {
            log.warn("{}秒内，请勿重复提交,antiReplayToken:{}，redisValue:{}",redisUtils.getExpire(redisKey),token,redisValue);
            returnJson(response,new DataResponse().fail().message(redisUtils.getExpire(redisKey)+"秒内，请勿重复提交"));
            return null;
        }
    }

    /**
     * 生成方法标记：采用数字签名算法SHA1对方法及请求参数字符串加签
     *
     * @param method
     * @param args
     * @return
     */
    private String getMethodSign(Method method, Object... args) {
        StringBuilder sb = new StringBuilder(method.toString());
        for (Object arg : args) {
            sb.append(toString(arg));
        }
        return DigestUtils.sha1DigestAsHex(sb.toString());
    }

    private String toString(Object arg) {
        if (Objects.isNull(arg)) {
            return "null";
        }
        if (arg instanceof Number) {
            return arg.toString();
        }
        return JSONObject.toJSONString(arg);
    }

    private void returnJson(HttpServletResponse response,Object object){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try{
            writer = response.getWriter();
            writer.print(JSONObject.toJSONString(object));
        }catch (IOException e){

        }finally {
            if(writer != null) writer.close();
        }
    }
}
