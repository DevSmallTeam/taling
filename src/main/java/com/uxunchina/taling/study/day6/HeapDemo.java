package com.uxunchina.taling.study.day6;

import com.uxunchina.taling.common.utils.JsoupUtil;

/**
 * heap demo
 * -Xms10m -Xmx1om
 * @author chenfeng
 * @date 2022/05/17 15:49
 **/
public class HeapDemo {

    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
