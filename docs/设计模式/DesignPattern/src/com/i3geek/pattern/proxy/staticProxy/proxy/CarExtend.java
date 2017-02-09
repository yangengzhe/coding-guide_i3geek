package com.i3geek.pattern.proxy.staticProxy.proxy;

import com.i3geek.pattern.proxy.staticProxy.real.Car;


public class CarExtend extends Car {

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        super.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶，用时："+(endtime -starttime));
    }

}
