package com.uxunchina.taling.study.day2.staticProxy;

public class SmsServiceImpl implements SmsService{

    private final static String MESSAGE_CODE_TRUE = "chenfeng";

    @Override
    public String send(String message) {
        System.out.println(String.format("send message:%s",message));
        return message;
    }

    @Override
    public boolean check(String messageCode) {
        if(MESSAGE_CODE_TRUE.equals(messageCode)){
            return true;
        }
        return false;
    }

    @Override
    public boolean check(String org, String target) {
        if(org.equals(target)){
            return true;
        }
        return false;
    }
}
