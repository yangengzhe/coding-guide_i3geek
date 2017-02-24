package com.i3geek.pattern.decorate;

import com.i3geek.pattern.decorate.component.Beverage;
import com.i3geek.pattern.decorate.concreteComponent.Espresso;
import com.i3geek.pattern.decorate.concreteComponent.HouseBlend;
import com.i3geek.pattern.decorate.concreteDecorator.Mocha;

/**
* 装饰模式
* @date 2017年2月23日 上午11:07:26
* @author gengzhe.ygz
* 
*/
public class Client {

    public static void main(String args[]){
        
        //没有装饰的情况下
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ "+beverage.cost());
        
        //装饰后
        beverage = new HouseBlend();
        beverage = new Mocha(beverage); //开始装饰第一层
        //可以装饰很多层
        //...
        System.out.println(beverage.getDescription() + " $ "+beverage.cost()); //完全一样的操作
    }
}
