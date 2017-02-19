package com.i3geek.pattern.singleton.client;

import com.i3geek.pattern.singleton.singleton.HungrySingleton;

/**
* DesignPattern
* @date 2017年2月19日 上午10:51:11
* @author gengzhe.ygz
* 
*/
public class Client {
    public static void main(String args[]){
        HungrySingleton singleton = HungrySingleton.getInstance();
    }
}
