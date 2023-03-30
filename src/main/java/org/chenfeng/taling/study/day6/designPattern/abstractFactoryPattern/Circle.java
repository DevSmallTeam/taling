package org.chenfeng.taling.study.day6.designPattern.abstractFactoryPattern;

/**
 * 圆形
 *
 * @author chenfeng
 * @date 2023/03/28 09:35
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
