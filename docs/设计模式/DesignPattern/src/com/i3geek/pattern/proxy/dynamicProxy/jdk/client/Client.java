package com.i3geek.pattern.proxy.dynamicProxy.jdk.client;

import java.awt.event.InvocationEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.i3geek.pattern.proxy.dynamicProxy.jdk.proxy.TimeHandler;
import com.i3geek.pattern.proxy.staticProxy.real.Car;
import com.i3geek.pattern.proxy.staticProxy.real.Moveable;

public class Client {

    public static void main(String[] args) {
        Car car =new Car();
        InvocationHandler h =new TimeHandler(car);
        Class<?> cls = car.getClass();
        
        //loader 类加载器，interfaces 实现接口，InvocationHandler
        //返回：代理后的对象
        Moveable m = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        
        m.move();
    }

}
