package com.i3geek.pattern.template;

import com.i3geek.pattern.template.Abstract.Base;
import com.i3geek.pattern.template.Concrete.Coffee;
import com.i3geek.pattern.template.Concrete.Tea;

public class Client {

    public static void main(String[] args) {
        Base base  = new Coffee();
        base.prepareTemplate();
        
        base = new Tea();
        base.prepareTemplate();
    }

}
