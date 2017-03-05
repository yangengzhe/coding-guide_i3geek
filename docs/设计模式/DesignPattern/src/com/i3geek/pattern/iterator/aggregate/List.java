package com.i3geek.pattern.iterator.aggregate;

import com.i3geek.pattern.iterator.iterator.Iterator;

/**
* 容器角色
* @date 2017年2月28日 下午1:14:34
* @author gengzhe.ygz
* 
*/
//定义集合可以进行的操作
public interface List {

  public void add(Object obj);  
  public Object get(int index);
  public Iterator iterator();  
  public int getSize();
}