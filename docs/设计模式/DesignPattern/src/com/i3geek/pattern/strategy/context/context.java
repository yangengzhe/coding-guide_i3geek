package com.i3geek.pattern.strategy.context;

import com.i3geek.pattern.strategy.strategy.Strategy;

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
