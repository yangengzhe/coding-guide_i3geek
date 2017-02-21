package com.i3geek.pattern.factory.abstractFactory.product;


/**
* DesignPattern
* @date 2017年2月20日 上午10:27:12
* @author gengzhe.ygz
* 
*/
public class BText implements Text {

    @Override
    public void input() {
        System.out.println("B文本框");
    }

}
