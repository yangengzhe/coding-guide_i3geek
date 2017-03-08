package com.i3geek.pattern.responsibilityChain.handler;


/**
* 责任链抽象类
* @date 2017年2月26日 下午6:07:44
* @author gengzhe.ygz
* 
*/
public abstract class Handler {
    private Handler nextHandler;
    //获得下一个责任者
    public Handler getNextHandler(){
        return nextHandler;
    }
    
    //设置下一个责任
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    
    //处理
    public abstract void doHandler(int money);
}
