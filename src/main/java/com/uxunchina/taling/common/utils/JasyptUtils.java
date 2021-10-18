package com.uxunchina.taling.common.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptUtils {


    private static final String ALGORITHM_INFO = "PBEWithMD5AndDES";

    private static final String PASSWORD_INFO = "chenfeng";

    public static void main(String[] args) {
        encryptPwd();
    }

    public static void encryptPwd() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        //配置文件中配置如下的算法
        standardPBEStringEncryptor.setAlgorithm(ALGORITHM_INFO);
        //配置文件中配置的password
        standardPBEStringEncryptor.setPassword(PASSWORD_INFO);
        //要加密的文本
        String name = standardPBEStringEncryptor.encrypt("root");
        String password = standardPBEStringEncryptor.encrypt("root");
        String redisPassword = standardPBEStringEncryptor.encrypt("123456");
        //将加密的文本写到配置文件中
        System.out.println("name=" + name);
        System.out.println("password=" + password);
        System.out.println("redisPassword=" + redisPassword);

        //要解密的文本
        String psw = standardPBEStringEncryptor.decrypt("5s1SKdcHPTvkADVzwdkNHg==");
        //解密后的文本
        System.out.println("psw=" + psw);

    }

}
