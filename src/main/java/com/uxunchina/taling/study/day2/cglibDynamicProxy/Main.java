package com.uxunchina.taling.study.day2.cglibDynamicProxy;

public class Main {

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        System.out.println(aliSmsService.send("flying fish"));
    }
}
