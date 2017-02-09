package com.i3geek.pattern.template.Concrete;

import com.i3geek.pattern.template.Abstract.Base;


/**
 * 具体子类
 * 
 * 提供了咖啡的实现
 * @date 2017年1月3日 下午4:06:15
 * @author yangengzhe
 *
 */
public class Coffee extends Base {

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶");
    }

    @Override
    protected void brew() {
       System.out.println("冲泡咖啡");
    }

}
