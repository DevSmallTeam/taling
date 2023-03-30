package org.chenfeng.taling.study.day6.designPattern.abstractFactoryPattern;

/**
 * 蓝色
 *
 * @author chenfeng
 * @date 2023/03/28 10:07
 **/
public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
