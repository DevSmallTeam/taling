package org.chenfeng.taling.system.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.chenfeng.taling.antiReplay.EnableAntiReplay;
import org.chenfeng.taling.common.utils.RedisUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author chenfeng
 * @Package org.chenfeng.taling.system.controller
 * @date 2019-08-27 16:55
 */
@Slf4j
@Controller
public class HelloController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @ApolloConfig
    private Config config;

    @Value("${app.name:chenfeng}")
    private String name;


    @ResponseBody
    @RequestMapping("/hello/{param}")
    @EnableAntiReplay(value = "hello",expireSeconds = 30)
//    @RequiresPermissions("system:view")
    public String index(Model model, @PathVariable String param){
        log.debug("debug级别日志");
        log.error("错误日志-----");
        log.info("这个是请求日志哟");
        model.addAttribute("id","123");
        model.addAttribute("names","你好！");
        redisTemplate.opsForValue().set("key1","value1");
        redisUtils.set("key2","value2");
        String value = (String)redisTemplate.opsForValue().get("key1");
        String value2 = (String)redisUtils.get("key2");
        log.warn("value1={},value2={}" ,value,value2);
        redisUtils.set("cf",1);
        redisUtils.incr("cf",100);
        log.info("redis Key:cf value:{}",redisUtils.get("cf"));
        Set<String> propertyNames = config.getPropertyNames();
        propertyNames.forEach(key -> {
            log.info("{}={}",key,config.getProperty(key,"123"));
        });


        return propertyNames.toString()+name;
    }

    public static String strSpecialFilter(String str) {
        String regEx = "[\\u00A0\\s\"`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}《》【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        //将所有的特殊字符替换为空字符串
        return m.replaceAll("").trim();
    }

    public static Integer getRemainSecondsOneDay(Date currentDate) {
        Calendar midnight=Calendar.getInstance();
        midnight.setTime(currentDate);
        midnight.add(midnight.DAY_OF_MONTH,1);
        midnight.set(midnight.HOUR_OF_DAY,0);
        midnight.set(midnight.MINUTE,0);
        midnight.set(midnight.SECOND,0);
        midnight.set(midnight.MILLISECOND,0);
        Integer seconds=(int)((midnight.getTime().getTime()-currentDate.getTime())/1000);
        return seconds;
    }

    public static Integer getRemainSecondsOneDay2(Date currentDate) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }

    public static void main(String[] args) {

        System.out.println(strSpecialFilter("大河明珠'1号楼<顺达标准件>《鲁迅收》[word]"));
        System.out.println(getRemainSecondsOneDay2(new Date()));

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("chenfeng");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("123456");
        System.out.println("username:"+username);
        System.out.println("password:"+password);

    }
}