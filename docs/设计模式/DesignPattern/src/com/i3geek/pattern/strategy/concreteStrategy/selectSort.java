package com.i3geek.pattern.strategy.concreteStrategy;

import com.i3geek.pattern.strategy.strategy.Strategy;


/**
 * 具体策略
 * @date 2017年2月26日 下午6:00:09
 * @author yangengzhe
 *
 */
public class selectSort implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("快排算法");
    }

}
