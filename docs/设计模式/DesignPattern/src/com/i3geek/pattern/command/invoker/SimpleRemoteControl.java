package com.i3geek.pattern.command.invoker;

import com.i3geek.pattern.command.command.Command;

/**
* 发送者（调用者）
* @date 2017年2月26日 下午12:21:40
* @author gengzhe.ygz
* 
*/
public class SimpleRemoteControl {
    //持有命令
    Command slot;
    
    //设置命令，可以改变行为
    public void setCommand(Command command) {
        slot = command;
    }
    
    //统一方法，按下按钮
    public void buttonPressed(){
        slot.execute();
    }
}
