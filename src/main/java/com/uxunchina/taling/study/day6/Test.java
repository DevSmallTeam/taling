package com.uxunchina.taling.study.day6;

/**
 * test
 *
 * @author chenfeng
 * @date 2022/05/18 18:42
 **/
public class Test {

    public static void main(String[] args) {
        int n =0;
        while(n++<30){
            a();
            b();
        };
    }


    public static void a(){
        long startTime=System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            String temp = "a"+i;
        }
        long endTime=System.nanoTime();
        System.out.println("方法 a() 运行时间：" + (endTime - startTime) + "ns");
    }

    public static void b(){
        long startTime=System.nanoTime();
        String temp = "a";
        for (int i = 0; i < 1000000; i++) {
            temp = "a" + i;
        }
        long endTime=System.nanoTime();
        System.out.println("方法 b() 运行时间：" + (endTime - startTime) + "ns");
    }

}

