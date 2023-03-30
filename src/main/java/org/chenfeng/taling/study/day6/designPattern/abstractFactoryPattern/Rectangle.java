package org.chenfeng.taling.study.day6.designPattern.abstractFactoryPattern;

/**
 * 长方形
 *
 * @author chenfeng
 * @date 2023/03/28 09:34
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
