package com.i3geek.pattern.template.Concrete;

import com.i3geek.pattern.template.Abstract.Base;


public class Tea extends Base {

    @Override
    protected void addCondiments() {
        System.out.println("加入柠檬");
    }

    @Override
    protected void brew() {
        System.out.println("用80度水浸泡");
    }

}
