package com.i3geek.pattern.observer.observer;

import com.i3geek.pattern.observer.subject.AbstractSubject;
import com.i3geek.pattern.observer.subject.ConcreteSubject;

public class ConcreteObserver implements Observer {
    
    String ObserverState;
    @Override
    public void update(AbstractSubject subject) {
        // TODO Auto-generated method stub
        this.ObserverState = ((ConcreteSubject)subject).getSubjectState();
    }

}
