package com.i3geek.pattern.decorate.component;


/**
* 基本组件，相当于抽象的Component类，被装饰者的抽象接口
* @date 2017年2月23日 上午10:54:08
* @author gengzhe.ygz
* 
*/
public interface Beverage {
    
    //获取描述信息
    public String getDescription();
    //获取价格
    public int cost();
}
