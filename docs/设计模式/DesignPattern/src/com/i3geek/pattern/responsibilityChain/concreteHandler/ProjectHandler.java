package com.i3geek.pattern.responsibilityChain.concreteHandler;

import com.i3geek.pattern.responsibilityChain.handler.Handler;


/**
* 最底层（入口） 责任处理者
* @date 2017年2月26日 下午6:14:50
* @author gengzhe.ygz
* 
*/
public class ProjectHandler extends Handler {

    @Override
    public void doHandler(int money) {
        if(money<500)
            System.out.println("项目经理审批："+money);
        else{
            System.out.println("项目经理上交");
            getNextHandler().doHandler(money);
        }
    }

}
