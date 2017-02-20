package com.i3geek.pattern.builder.builder;


/**
* 所需要的零部件
* @date 2017年2月18日 下午12:04:44
* @author gengzhe.ygz
* 
*/
public interface Builder {
    void buildFoundation();
    void buildFrame();
    void buildWall();
    String getType();
}
