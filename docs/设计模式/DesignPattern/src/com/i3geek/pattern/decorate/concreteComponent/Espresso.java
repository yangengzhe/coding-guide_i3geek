package com.i3geek.pattern.decorate.concreteComponent;

import com.i3geek.pattern.decorate.component.Beverage;


/**
* 被装饰者，具体构件
* 我们将要动态地加上新行为的对象，它扩展自Component
* @date 2017年2月23日 上午10:56:17
* @author gengzhe.ygz
* 
*/
public class Espresso implements Beverage {

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public int cost() {
        return 10;
    }

}
