package com.i3geek.pattern.adapter.Client;

import com.i3geek.pattern.adapter.Adaptee.TwoPlug;
import com.i3geek.pattern.adapter.Adapter.Two2ThreeAdapter;
import com.i3geek.pattern.adapter.Adapter.Two2ThreeAdapterExtends;
import com.i3geek.pattern.adapter.Target.ThreePlug;

public class NoteBook {
    private ThreePlug plug;
    
    public NoteBook(ThreePlug plug) {
        this.plug = plug;
    }
    //使用插座充电
    public void charge(){
        plug.powerWithThree();
    }
    
    public static void main(String args[]){
        //对象适配器
        TwoPlug twoPlug = new TwoPlug();
        ThreePlug plug = new Two2ThreeAdapter(twoPlug);
        NoteBook nBook = new NoteBook(plug);
        nBook.charge();
        
        //类适配器
        plug = new Two2ThreeAdapterExtends();
        nBook = new NoteBook(plug);
        nBook.charge();
    }
}
