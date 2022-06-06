package com.uxunchina.taling.study.day6;

/**
 * 测试大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *
 * @author chenfeng
 * @date 2022/05/25 16:58
 **/
public class YoungOldAreaTest {
    public static void main(String[] args) {
        //定义一个20m的数组
        byte[] bytes = new byte[1024 * 1024 * 20];
    }
}
