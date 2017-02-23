package com.i3geek.pattern.bridge.first;


/**
* DesignPattern
* @date 2017年2月22日 上午10:05:08
* @author gengzhe.ygz
* 
*/
public class ConcreteImplementorA implements Implementor {

    @Override
    public void func() {
        System.out.println("矩形");
    }

}
