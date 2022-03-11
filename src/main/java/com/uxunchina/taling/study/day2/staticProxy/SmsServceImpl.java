package com.uxunchina.taling.study.day2.staticProxy;

public class SmsServceImpl implements SmsService{

    @Override
    public String send(String message) {
        System.out.println(String.format("send message:%s",message));
        return message;
    }
}
