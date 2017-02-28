package com.i3geek.pattern.command.concreteCommand;

import com.i3geek.pattern.command.command.Command;
import com.i3geek.pattern.command.receiver.Light;


/**
* 命令实现类——对接收者的操作
* @date 2017年2月26日 下午12:17:52
* @author gengzhe.ygz
* 
*/
public class LightOnCommand implements Command {
    
    //接收者绑定：真正执行的人
    Light light;
    
    public LightOnCommand(Light light){
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
