package com.uxunchina.taling.system.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.uxunchina.taling.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;
import java.util.Set;


/**
 * @author chenfeng
 * @Package com.uxunchina.taling.system.controller
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
    @RequestMapping("/hello")
    @RequiresPermissions("system:view")
    public String index(Model model){
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

        Set<String> propertyNames = config.getPropertyNames();
        propertyNames.forEach(key -> {
            log.info("{}={}",key,config.getProperty(key,"123"));
        });


        return propertyNames.toString()+name;
    }

}