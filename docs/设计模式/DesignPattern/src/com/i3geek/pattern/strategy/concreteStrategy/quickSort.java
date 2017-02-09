package com.i3geek.pattern.strategy.concreteStrategy;

import com.i3geek.pattern.strategy.strategy.Strategy;


public class quickSort implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("选择排序算法");
    }

}
