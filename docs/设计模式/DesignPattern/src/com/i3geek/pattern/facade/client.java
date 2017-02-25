package com.i3geek.pattern.facade;

import com.i3geek.pattern.facade.facade.Cinema;
import com.i3geek.pattern.facade.subSystem.DVDplayer;
import com.i3geek.pattern.facade.subSystem.Light;
import com.i3geek.pattern.facade.subSystem.Screen;

/**
* DesignPattern
* @date 2017年2月25日 下午12:03:24
* @author gengzhe.ygz
* 
*/
public class client {
    public static void main(String args[]){
        //准备组件（子系统）
        DVDplayer dvdplayer = new DVDplayer();
        Light light = new Light();
        Screen screen = new Screen();
        //准备门面类
        Cinema cinema = new Cinema(light, screen, dvdplayer);
        
        //看电影
        cinema.WatchMovie();
        
        //看完电影
        cinema.EndMovie();
    }
}
