package com.i3geek.pattern.factory.abstractFactory.product;


/**
* DesignPattern
* @date 2017年2月20日 上午10:26:27
* @author gengzhe.ygz
* 
*/
public class AText implements Text {

    @Override
    public void input() {
        System.out.println("A文本框");
    }
}
