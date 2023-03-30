package org.chenfeng.taling.study.day6.designPattern.singletonPattern;

/**
 * 懒汉式 - 线程不安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 *
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 *
 * @author chenfeng
 * @date 2023/03/28 10:36
 **/
public class Singleton2 {

    private static Singleton2 instance;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if (instance == null){
            return new Singleton2();
        }
        return instance;
    }
}
