package com.i3geek.pattern.proxy.staticProxy.client;

import com.i3geek.pattern.proxy.staticProxy.proxy.CarExtend;
import com.i3geek.pattern.proxy.staticProxy.proxy.CarImplement;
import com.i3geek.pattern.proxy.staticProxy.real.Car;
import com.i3geek.pattern.proxy.staticProxy.real.Moveable;

public class Client {

    public static void main(String[] args) {
        //静态代理 继承
        Moveable moveable = new CarExtend();
        moveable.move();
        
        //静态代理 聚合
        Car car = new Car();
        moveable = new CarImplement(car);
        moveable.move();
    }

}
