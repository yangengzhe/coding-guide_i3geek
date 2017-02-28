package com.i3geek.pattern.command;

import com.i3geek.pattern.command.concreteCommand.LightOnCommand;
import com.i3geek.pattern.command.invoker.SimpleRemoteControl;
import com.i3geek.pattern.command.receiver.Light;

/**
* DesignPattern
* @date 2017年2月26日 下午12:23:39
* @author gengzhe.ygz
* 
*/
public class Client {

    public static void main(String[] args) {
     // 控制器就是调用者，会传入一个命令对象，可以用来发出请求
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // 现在创建了一个电灯对象，此对象也就是请求的接收者
        Light light = new Light();
        // 在这里创建一个命令，然后将接收者传给它
        LightOnCommand lightOn = new LightOnCommand(light);

        // 把命令传给调用者
        remote.setCommand(lightOn);
        // 模拟按下按钮
        remote.buttonPressed();
    }

}
