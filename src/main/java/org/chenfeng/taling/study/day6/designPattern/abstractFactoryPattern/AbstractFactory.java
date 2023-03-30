package org.chenfeng.taling.study.day6.designPattern.abstractFactoryPattern;

/**
 * 抽象工厂类
 *
 * @author chenfeng
 * @date 2023/03/28 10:08
 **/
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
