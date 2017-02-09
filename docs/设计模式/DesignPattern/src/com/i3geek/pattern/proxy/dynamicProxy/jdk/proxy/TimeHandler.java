package com.i3geek.pattern.proxy.dynamicProxy.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class TimeHandler implements InvocationHandler {
    
    private Object target;
    
    public TimeHandler(Object target){
        this.target = target;
    }
    /* proxy : 被代理对象
     * method : 被代理对象的方法
     * args : 方法的参数
     * 
     * 返回值
     * Object ： 方法返回值
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long starttime = System.currentTimeMillis();
        method.invoke(target);
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶，用时："+(endtime -starttime));
        return null;
    }

}
