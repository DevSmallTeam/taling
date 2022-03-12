package com.uxunchina.taling.study.day2.cglibDynamicProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理实现
 * 1、定义一个类；
 * 2、自定义 MethodInterceptor 并重写 intercept 方法，
 * intercept 用于拦截增强被代理类的方法，和 JDK 动态代理中的 invoke 方法类似；
 * 3、通过 Enhancer 类的 create()创建代理类；
 * #
 */
public class DebugMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before method："+method.getName());
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("cglib after method："+method.getName());
        return result;
    }
}
