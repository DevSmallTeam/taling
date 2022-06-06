package com.uxunchina.taling.study.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * GC test
 *  -Xms6m -Xmx6m -XX:+PrintGCDetails
 * @author chenfeng
 * @date 2022/05/23 17:23
 **/
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello world!";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable t) {
            System.out.println("遍历次数：" + i);
            t.printStackTrace();
        }

    }
}


