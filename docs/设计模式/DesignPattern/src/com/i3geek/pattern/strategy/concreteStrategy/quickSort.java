package com.i3geek.pattern.strategy.concreteStrategy;

import com.i3geek.pattern.strategy.strategy.Strategy;


/**
 * 具体策略
 * @date 2017年2月26日 下午6:00:00
 * @author yangengzhe
 *
 */
public class quickSort implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("选择排序算法");
    }

}
