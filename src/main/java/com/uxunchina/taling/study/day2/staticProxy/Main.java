package com.uxunchina.taling.study.day2.staticProxy;

public class Main {

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        System.out.println(smsProxy.send("chenfeng"));
    }
}
