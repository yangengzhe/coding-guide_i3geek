package com.i3geek.pattern.proxy.dynamicProxy.cglib.proxy;

import java.lang.reflect.Method;

import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class cglibProxy implements MethodInterceptor{
    private Enhancer enhancer = new Enhancer();
    
    public Object getProxy(Class clazz){
        //设置创建子类的类（设置被代理类）
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        
        return enhancer.create();//返回子类
    }
    /**
     * 拦截所有目标类方法的调用
     * @param obj 目标类的实例
     * @param m目标方法的反射对象
     * @param args方法的参数
     * @param proxy代理类的实例
     * @return
     * @throws Throwable
     * @author ygz 下午8:16:40
     */
    @Override
    public Object intercept(Object obj,Method m,Object[] args,MethodProxy proxy) throws Throwable{
        System.out.println("开始");
        //代理类调用父类的方法
        proxy.invokeSuper(obj,args);
        System.out.println("结束");
        return null;
    }
}
