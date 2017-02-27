package com.i3geek.pattern.strategy;

import com.i3geek.pattern.strategy.concreteStrategy.quickSort;
import com.i3geek.pattern.strategy.concreteStrategy.selectSort;
import com.i3geek.pattern.strategy.context.context;

public class Client {
    public static void main(String args[]){
        quickSort quick = new quickSort();
        selectSort select = new selectSort();
        
        context c = new context();
        c.setStrategy(quick);
        c.doAction();
        
        //更换算法
        c.setStrategy(select);
        c.doAction();
    }
}
