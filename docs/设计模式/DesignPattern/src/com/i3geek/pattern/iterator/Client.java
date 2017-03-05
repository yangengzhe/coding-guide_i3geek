package com.i3geek.pattern.iterator;

import com.i3geek.pattern.iterator.aggregate.List;
import com.i3geek.pattern.iterator.concreteAggregate.ConcreteAggregate;
import com.i3geek.pattern.iterator.iterator.Iterator;

/**
* DesignPattern
* @date 2017年2月28日 下午1:16:24
* @author gengzhe.ygz
* 
*/
public class Client {

    public static void main(String[] args) {

        List list=new ConcreteAggregate();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
