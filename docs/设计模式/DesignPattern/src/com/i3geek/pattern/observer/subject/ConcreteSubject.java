package com.i3geek.pattern.observer.subject;


/**
 * 具体目标类，达到效果：当subjectState变化 就通知所有观察者
 * @date 2017年1月16日 下午7:27:03
 * @author yangengzhe
 *
 */
public class ConcreteSubject extends AbstractSubject {
    //目标对象的状态  《== 变化时就通知所有观察者
    private String subjectState;

    
    public String getSubjectState() {
        return subjectState;
    }

    
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        System.out.println("通知大家了！");
        this.notifyObservers();
    }
    
    
}
