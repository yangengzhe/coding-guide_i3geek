package com.i3geek.pattern.adapter;

import com.i3geek.pattern.adapter.Adaptee.TwoPlug;
import com.i3geek.pattern.adapter.Adapter.Two2ThreeAdapter;
import com.i3geek.pattern.adapter.Adapter.Two2ThreeAdapterExtends;
import com.i3geek.pattern.adapter.Target.ThreePlug;

public class Client {
    
    public static void main(String args[]){
        //对象适配器
        TwoPlug twoPlug = new TwoPlug();
        ThreePlug plug = new Two2ThreeAdapter(twoPlug);
        plug.powerWithThree();
        
        //类适配器
        plug = new Two2ThreeAdapterExtends();
        plug.powerWithThree();
    }
}
