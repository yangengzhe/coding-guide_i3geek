package com.i3geek.pattern.template.Abstract;

import sun.io.ByteToCharMacHebrew;

/**
 *  抽象基类，为所有子类提供一个算法框架
 * @date 2017年1月3日 下午3:31:05
 * @author yangengzhe
 *
 */
public abstract class Base {
    
    /**
     * 该方法即模板方法，规范了算法（过程）的实现步骤
     * 模板方法，封装了所有子类共同遵循的算法步骤框架，不能被修改 因此不能被继承
     * @author ygz 下午3:32:44
     */
    public final void prepareTemplate(){
        //步骤一：将水煮沸
        boilWater();
        //步骤二：泡制饮料
        brew();
        //步骤三：倒入杯中
        pourInCup();
        //步骤四：加入调味料
        addCondiments();
    }

    /**
     * 抽象的基本方法，用于加入调料，由子类实现
     * @author ygz 下午4:02:02
     * @return 
     */
    protected abstract void addCondiments();
    
    /**
     * 基本方法，通用的，没有区别的方法。不用子类考虑，因此定义为私有的
     * @author ygz 下午4:00:26
     */
    private void pourInCup() {
        System.out.println("倒入杯中");
    }

    /**
     * 抽象的基本方法，用于泡制饮料，由子类实现
     * @author ygz 下午4:02:02
     * @return 
     */
    protected abstract void brew();
    
    /**
     * 基本方法，通用的，没有区别的方法。不用子类考虑，因此定义为私有的
     * @author ygz 下午4:00:26
     */
    private void boilWater() {
        System.out.println("煮沸水");
        
    }
    
}
