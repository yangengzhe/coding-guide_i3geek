package com.i3geek.pattern.builder.concreteBuilder;

import com.i3geek.pattern.builder.builder.Builder;


/**
* 砖瓦房
* @date 2017年2月18日 下午12:09:35
* @author gengzhe.ygz
* 
*/
public class BrickBuilder implements Builder {
    public String type = "砖瓦房";
    
    @Override
    public void buildFoundation() {
        System.out.println("砖瓦房地基");
    }

    @Override
    public void buildFrame() {
        System.out.println("砖瓦房框架");
    }

    @Override
    public void buildWall() {
        System.out.println("砖瓦房墙壁");
    }

    @Override
    public String getType() {
        return type;
    }

}
