package com.i3geek.pattern.proxy.dynamicProxy.cglib.client;

import com.i3geek.pattern.proxy.dynamicProxy.cglib.proxy.cglibProxy;
import com.i3geek.pattern.proxy.dynamicProxy.cglib.real.Train;

public class Client {

    public static void main(String args[]) {
        
        cglibProxy proxy = new cglibProxy();
        //获得被代理类的子类
        Train train = (Train)proxy.getProxy(Train.class);
        train.move();
    }
}
