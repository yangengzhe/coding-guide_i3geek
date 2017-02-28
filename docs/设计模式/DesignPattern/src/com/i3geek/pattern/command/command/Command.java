package com.i3geek.pattern.command.command;


/**
* 命令抽象接口
* @date 2017年2月26日 下午12:17:02
* @author gengzhe.ygz
* 
*/
public interface Command {
    //执行命令
    public void execute();
    
    //撤销命令
    public void undo();
}
