package com.i3geek.pattern.strategy.concreteStrategy;

import com.i3geek.pattern.strategy.strategy.Strategy;


public class selectSort implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("快排算法");
    }

}
