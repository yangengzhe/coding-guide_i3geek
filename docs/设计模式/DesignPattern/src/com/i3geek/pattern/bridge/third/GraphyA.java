package com.i3geek.pattern.bridge.third;

import com.i3geek.pattern.bridge.second.Abstraction;

/**
* DesignPattern
* @date 2017年2月22日 上午10:12:39
* @author gengzhe.ygz
* 
*/
public class GraphyA implements Graphy {
    
    Abstraction second;
    
    public GraphyA(Abstraction second){
        this.second =second;
    }
    @Override
    public void func() {
        System.out.println("手绘");
        second.func();
    }

}
