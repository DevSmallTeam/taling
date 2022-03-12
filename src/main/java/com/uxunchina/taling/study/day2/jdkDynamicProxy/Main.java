package com.uxunchina.taling.study.day2.jdkDynamicProxy;

import com.uxunchina.taling.study.day2.staticProxy.SmsService;
import com.uxunchina.taling.study.day2.staticProxy.SmsServiceImpl;

public class Main {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        System.out.println(smsService.send("chenfeng"));
        System.out.println(smsService.check("chenfeng1"));
        System.out.println(smsService.check("chenfeng","chenfeng"));
    }
}
