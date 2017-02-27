package com.i3geek.pattern.strategy.context;

import com.i3geek.pattern.strategy.strategy.Strategy;

/**
 * 环境类，存放策略
 * @date 2017年2月26日 下午5:59:25
 * @author yangengzhe
 *
 */
public class context {
    private Strategy strategy;
    
    public void doAction(){
        strategy.algorithm();
    }
    
    public Strategy getStrategy() {
        return strategy;
    }

    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
}
