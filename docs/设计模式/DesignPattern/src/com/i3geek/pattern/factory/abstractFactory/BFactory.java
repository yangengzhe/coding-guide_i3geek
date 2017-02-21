package com.i3geek.pattern.factory.abstractFactory;

import com.i3geek.pattern.factory.abstractFactory.product.BText;
import com.i3geek.pattern.factory.abstractFactory.product.Text;
import com.i3geek.pattern.factory.product.BButton;
import com.i3geek.pattern.factory.product.Button;


/**
* DesignPattern
* @date 2017年2月20日 上午10:25:30
* @author gengzhe.ygz
* 
*/
public class BFactory implements IFactory {

    @Override
    public Button createButton() {
        return new BButton();
    }

    @Override
    public Text createText() {
        return new BText();
    }

}
