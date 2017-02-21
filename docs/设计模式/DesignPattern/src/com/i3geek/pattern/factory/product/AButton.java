package com.i3geek.pattern.factory.product;


/**
* DesignPattern
* @date 2017年2月20日 上午10:01:38
* @author gengzhe.ygz
* 
*/
public class AButton implements Button {

    @Override
    public void click() {
        System.out.println("按钮A");
    }

}
