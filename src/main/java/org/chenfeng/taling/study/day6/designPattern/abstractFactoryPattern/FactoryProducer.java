package org.chenfeng.taling.study.day6.designPattern.abstractFactoryPattern;

/**
 * 工厂生成器
 *
 * @author chenfeng
 * @date 2023/03/28 10:12
 **/
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }else {
            return null;
        }
    }
}
