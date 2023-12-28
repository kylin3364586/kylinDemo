package com.kylindemo.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auth kylin
 * @date 2023/12/28 11:05
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;//代理的目标类

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //生成的代理对象
    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("业务方法调用之前。。。");
        Object invoke = proxy.invoke(target, args);
        System.out.println("业务方法调用之后。。。");
        return invoke;
    }
}
