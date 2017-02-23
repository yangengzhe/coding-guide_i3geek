package com.i3geek.pattern.bridge;

import com.i3geek.pattern.bridge.first.ConcreteImplementorA;
import com.i3geek.pattern.bridge.first.Implementor;
import com.i3geek.pattern.bridge.second.Abstraction;
import com.i3geek.pattern.bridge.second.RefinedAbstractionA;
import com.i3geek.pattern.bridge.third.Graphy;
import com.i3geek.pattern.bridge.third.GraphyA;

/**
* 桥接设计模式，三层关系解耦
* @date 2017年2月22日 上午10:14:29
* @author gengzhe.ygz
* 
*/
public class Client {
    
    public static void main(String[] args) {
        //第一层
        Implementor first = new ConcreteImplementorA();
        //第二层
        Abstraction second = new RefinedAbstractionA(first);
        //第三层
        Graphy third = new GraphyA(second);
        
        //测试
        third.func();
    }

}
