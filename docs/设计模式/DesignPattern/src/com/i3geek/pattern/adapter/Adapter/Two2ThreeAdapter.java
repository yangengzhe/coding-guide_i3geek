package com.i3geek.pattern.adapter.Adapter;

import com.i3geek.pattern.adapter.Adaptee.TwoPlug;
import com.i3geek.pattern.adapter.Target.ThreePlug;

/**
 * 二相转三相的适配器 （目标接口的实现、目标接口的实例）
 * 对象适配器
 * @date 2016年12月29日 下午4:30:24
 * @author yangengzhe
 *
 */
public class Two2ThreeAdapter implements ThreePlug {
    
    private TwoPlug plug;
    
    public Two2ThreeAdapter(TwoPlug plug){
        this.plug = plug;
    }
    @Override 
    public void powerWithThree() {
        System.out.println("通过组合适配器");
        plug.powerWithTwo();
    }

}
