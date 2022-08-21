package org.chenfeng.taling.common.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class LogAspect {


//    @Pointcut("@annotation(org.chenfeng.taling.common.aspect.MyLogReport)")
    @Pointcut("execution(* org.chenfeng.taling..controller..*.*(..))")
    public void pointCut() {

    }

    /**
     * 环绕操作
     *
     * @param joinPoint 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("pointCut()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        MyLogReport myLogReport = method.getAnnotation(MyLogReport.class);
//        if(myLogReport == null){
//            return joinPoint.proceed();
//        }
        //获取需要打印的参数信息
        Long start = System.currentTimeMillis();
        log.info("\n");
        log.info("request report -------- {} -------------------------", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        log.info("Request     : {} {}", request.getMethod(), request.getRequestURI());
        log.info("Controller  : {}", joinPoint.getTarget().getClass());
        log.info("Method      : {}", joinPoint.getSignature().getDeclaringTypeName(), ".", joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        log.info("UrlParam    : {}", Arrays.toString(joinPoint.getArgs()));
        Long end = System.currentTimeMillis();
        log.info("Return      : {}", JSON.toJSON(result));
        log.info("------------------------------- taked {} ms --------------------------------", end - start);
        log.info("\n");
        return result;
    }

}
