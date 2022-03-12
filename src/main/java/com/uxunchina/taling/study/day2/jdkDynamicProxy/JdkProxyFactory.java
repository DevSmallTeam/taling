package com.uxunchina.taling.study.day2.jdkDynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 代理对象工厂类
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                //目标类的类加载
                target.getClass().getClassLoader(),
                //代理需要实现类的接口
                target.getClass().getInterfaces(),
                //代理对象自定义的invocationHandle
                new DebugInvocationHandler(target));
    }
}
