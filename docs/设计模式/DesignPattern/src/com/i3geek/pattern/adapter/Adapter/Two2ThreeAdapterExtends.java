package com.i3geek.pattern.adapter.Adapter;

import com.i3geek.pattern.adapter.Adaptee.TwoPlug;
import com.i3geek.pattern.adapter.Target.ThreePlug;


/**
 * 继承方式的类适配器
 * @date 2016年12月29日 下午4:50:15
 * @author yangengzhe
 *
 */
public class Two2ThreeAdapterExtends extends TwoPlug implements ThreePlug {

    @Override
    public void powerWithThree() {
        System.out.println("通过继承适配器");
        this.powerWithTwo();
    }

}
