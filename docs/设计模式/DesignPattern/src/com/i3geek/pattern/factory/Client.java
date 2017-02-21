package com.i3geek.pattern.factory;

import com.i3geek.pattern.factory.abstractFactory.AFactory;
import com.i3geek.pattern.factory.abstractFactory.BFactory;
import com.i3geek.pattern.factory.abstractFactory.IFactory;
import com.i3geek.pattern.factory.abstractFactory.product.Text;
import com.i3geek.pattern.factory.factory.AButtonFactory;
import com.i3geek.pattern.factory.factory.BButtonFactory;
import com.i3geek.pattern.factory.factory.Factory;
import com.i3geek.pattern.factory.product.Button;
import com.i3geek.pattern.factory.simpleFactory.ButtonSFactory;

/**
* 三种工厂方法模式
* @date 2017年2月20日 上午9:56:23
* @author gengzhe.ygz
* 
*/
public class Client {

    public static void main(String[] args) {
        //简单工厂模式
        ButtonSFactory sf = new ButtonSFactory();
        Button button = sf.createButton(0); // 同一工厂根据不同的参数 生产不同的产品
//        button = sf.createButton(1);
        button.click();
        
        //工厂方法模式
        Factory factory = new AButtonFactory();//不同的工厂 生产不同的产品
//        factory = new BButtonFactory();
        button = factory.createButton();
        button.click();
        
        //抽象工厂模式
        IFactory iFactory = new AFactory();//不同的工厂 生产不同系列的产品
//        iFactory = new BFactory();
        button = iFactory.createButton();
        Text text = iFactory.createText();
        button.click();
        text.input();
    }

}
