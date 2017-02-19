package com.i3geek.pattern.singleton.singleton;

/**
* 单例模式 饿汉模式 线程安全
* @date 2017年2月19日 上午10:47:29
* @author gengzhe.ygz
* 
*/
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    
    public static HungrySingleton getInstance(){
        return instance;
    }
}
