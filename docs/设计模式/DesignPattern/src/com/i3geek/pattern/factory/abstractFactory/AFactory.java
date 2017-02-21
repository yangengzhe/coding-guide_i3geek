package com.i3geek.pattern.factory.abstractFactory;

import com.i3geek.pattern.factory.abstractFactory.product.AText;
import com.i3geek.pattern.factory.abstractFactory.product.Text;
import com.i3geek.pattern.factory.product.AButton;
import com.i3geek.pattern.factory.product.Button;


/**
* DesignPattern
* @date 2017年2月20日 上午10:24:53
* @author gengzhe.ygz
* 
*/
public class AFactory implements IFactory {

    @Override
    public Button createButton() {
        return new AButton();
    }

    @Override
    public Text createText() {
        return new AText();
    }

}
