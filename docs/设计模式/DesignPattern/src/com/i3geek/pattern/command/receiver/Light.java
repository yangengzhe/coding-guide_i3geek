package com.i3geek.pattern.command.receiver;


/**
* 命令接收者，真正执行的人
* @date 2017年2月26日 下午12:18:39
* @author gengzhe.ygz
* 
*/
public class Light {
    public void on(){
        System.out.println("开灯");
    }
    
    public void off(){
        System.out.println("关灯");
    }
}
