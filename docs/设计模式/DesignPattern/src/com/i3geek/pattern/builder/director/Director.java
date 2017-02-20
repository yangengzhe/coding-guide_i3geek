package com.i3geek.pattern.builder.director;

import com.i3geek.pattern.builder.builder.Builder;
import com.i3geek.pattern.builder.product.House;

/**
* 指挥者
* @date 2017年2月18日 下午12:03:58
* @author gengzhe.ygz
* 
*/
public class Director {
    
    public House Construct(Builder builder){
        builder.buildFoundation();
        builder.buildFrame();
        builder.buildWall();
        return new House(builder.getType());
    }
}
