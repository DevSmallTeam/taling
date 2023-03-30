package org.chenfeng.taling.study.day2.jdkDynamicProxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.chenfeng.taling.study.day2.staticProxy.SmsService;
import org.chenfeng.taling.study.day2.staticProxy.SmsServiceImpl;

public class Main {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        System.out.println(smsService.send("chenfeng"));
        System.out.println(smsService.check("chenfeng1"));
        System.out.println(smsService.check("chenfeng","chenfeng"));

        JSONObject data = JSON.parseObject("{\"openId\":\"test\"}");
        System.out.println(data.get("openId").toString());
        String a = "idType=null";
        String[] as = a.split("=");
        System.out.println(as.length);
    }
}
