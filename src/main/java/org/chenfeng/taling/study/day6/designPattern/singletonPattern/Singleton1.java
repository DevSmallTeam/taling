package org.chenfeng.taling.study.day6.designPattern.singletonPattern;

/**
 * 饥汉式
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 *
 * @author chenfeng
 * @date 2023/03/28 10:33
 **/
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }
}
