package com.i3geek.pattern.factory.product;


/**
* DesignPattern
* @date 2017年2月20日 上午10:01:50
* @author gengzhe.ygz
* 
*/
public class BButton implements Button {

    @Override
    public void click() {
        System.out.println("按钮B");
    }

}
