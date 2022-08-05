package com.collect.java8.typeInfo.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.doSomething("888899");
    }

    public static void main(String[] args){
        RealObject realObject = new RealObject();
        consumer(realObject);

        //类加载器
        Interface roxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObject));
        consumer(roxy);
    }
}

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;

    DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** PROXY *** " + proxy.getClass() +", method" + method + ",args" + args);
        if(args != null){
            for(Object arg : args){
                System.out.println(arg);
            }
        }
        return method.invoke(proxied, args);
    }
}