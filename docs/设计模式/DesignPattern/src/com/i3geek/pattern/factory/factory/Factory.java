package com.i3geek.pattern.factory.factory;

import com.i3geek.pattern.factory.product.Button;

/**
* 工厂方法模式，工厂抽象类
* 简单工厂模式下+多个工厂实现类（生成一个工厂抽象类）
* @date 2017年2月20日 上午10:10:50
* @author gengzhe.ygz
* 
*/
public interface Factory {
    public Button createButton();
}
