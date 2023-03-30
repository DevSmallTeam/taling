package org.chenfeng.taling.study.day6.designPattern.factoryPattern;

/**
 * 正方形
 *
 * @author chenfeng
 * @date 2023/03/28 09:35
 **/
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
