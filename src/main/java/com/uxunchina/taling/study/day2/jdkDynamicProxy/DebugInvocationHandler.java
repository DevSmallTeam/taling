package com.uxunchina.taling.study.day2.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理实现：
 * 1、定义一个接口及其实现类；
 * 2、自定义 InvocationHandler 并重写invoke方法，在 invoke 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
 * 3、通过 Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) 方法创建代理对象；
 * #
 */
public class DebugInvocationHandler implements InvocationHandler {

    /**
     * 代理真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before do something...
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target,args);
        //after do something...
        System.out.println("after method " + method.getName());
        return result;
    }


}
