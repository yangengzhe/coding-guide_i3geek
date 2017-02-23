package com.i3geek.pattern.bridge.third;

import com.i3geek.pattern.bridge.second.Abstraction;

/**
* DesignPattern
* @date 2017年2月22日 上午10:12:50
* @author gengzhe.ygz
* 
*/
public class GraphyB implements Graphy {

    Abstraction second;
    
    public GraphyB(Abstraction second){
        this.second =second;
    }
    
    @Override
    public void func() {
        System.out.println("机器绘制");
        second.func();
    }

}
