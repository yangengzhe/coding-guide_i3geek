package com.i3geek.pattern.facade.subSystem;


/**
* 子系统——控制灯
* @date 2017年2月25日 上午11:54:29
* @author gengzhe.ygz
* 
*/
public class Light {
    public void open(){
        System.out.println("灯已经打开");
    }
    
    public void close(){
        System.out.println("灯已经关闭");
    }
}
