package com.i3geek.pattern.builder;

import com.i3geek.pattern.builder.builder.Builder;
import com.i3geek.pattern.builder.concreteBuilder.BrickBuilder;
import com.i3geek.pattern.builder.director.Director;
import com.i3geek.pattern.builder.product.House;

/**
* DesignPattern
* @date 2017年2月18日 下午12:25:40
* @author gengzhe.ygz
* 
*/
public class client {
    
    public static void main(String args[]){
        Director director = new Director();
        Builder builder = new BrickBuilder();
        
        House house = director.Construct(builder);
        System.out.println(house.getType());
    }
}
