package org.chenfeng.taling.study.day2.staticProxy;

public interface SmsService {
    /**
     * 发送接口
     * @param message
     * @return
     */
    String send(String message);

    /**
     * 校验接口
     * @param messageCode
     * @return
     */
    boolean check(String messageCode);


    boolean check(String org,String target);
}
