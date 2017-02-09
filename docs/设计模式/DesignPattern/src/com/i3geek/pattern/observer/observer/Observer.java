package com.i3geek.pattern.observer.observer;

import javax.security.auth.Subject;

import com.i3geek.pattern.observer.subject.AbstractSubject;

/**
 * 观察者接口，定义通知接口
 * @date 2017年1月16日 下午7:18:13
 * @author yangengzhe
 *
 */
public interface Observer {
    public void update(AbstractSubject subject);
}
