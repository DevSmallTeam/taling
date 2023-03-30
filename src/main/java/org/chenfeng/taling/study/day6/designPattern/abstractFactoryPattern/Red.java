package org.chenfeng.taling.study.day6.designPattern.abstractFactoryPattern;

/**
 * 红色
 *
 * @author chenfeng
 * @date 2023/03/28 10:06
 **/
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
