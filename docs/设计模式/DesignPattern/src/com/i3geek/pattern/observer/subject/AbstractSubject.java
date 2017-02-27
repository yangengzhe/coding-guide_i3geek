package com.i3geek.pattern.observer.subject;

import java.util.ArrayList;
import java.util.List;

import com.i3geek.pattern.observer.observer.Observer;

/**
 *  目标抽象类（被观察者）。用于保存观察者列表，提供注册和删除观察者的操作。
 *  一旦自己改变，立刻通知观察者
 * @date 2017年1月16日 下午7:21:49
 * @author yangengzhe
 *
 */
public abstract class AbstractSubject {
    private List<Observer> observers = new ArrayList<Observer>();
    
    //注册
    public void attach(Observer observer){
        observers.add(observer);
    }
    
    //删除
    public void detach(Observer observer){
        observers.remove(observer);
    }
    
    //通知
    protected void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
