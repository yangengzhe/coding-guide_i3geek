package com.i3geek.pattern.builder.concreteBuilder;

import com.i3geek.pattern.builder.builder.Builder;


/**
* DesignPattern
* @date 2017年2月18日 下午12:08:40
* @author gengzhe.ygz
* 
*/
public class ThatchedBuilder implements Builder {
    public String type = "茅草屋";

    @Override
    public void buildFoundation() {
        System.out.println("茅草屋地基");
    }

    @Override
    public void buildFrame() {
        System.out.println("茅草屋框架");
    }

    @Override
    public void buildWall() {
        System.out.println("茅草屋墙壁");
    }

    @Override
    public String getType() {
        return type;
    }

}
