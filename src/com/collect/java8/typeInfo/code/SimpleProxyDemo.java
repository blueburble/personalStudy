package com.collect.java8.typeInfo.code;

public class SimpleProxyDemo {
    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

    public static void consumer(Interface face){
        face.doSomething();
        face.doSomething("114");
    }
}

interface Interface{
    void doSomething();

    void doSomething(String arg);
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomething(String arg) {
        System.out.println("doSomething" + arg);
    }
}

class SimpleProxy implements Interface{

    private Interface anInterface;

    public SimpleProxy(Interface proxied){
        this.anInterface = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        anInterface.doSomething();
    }

    @Override
    public void doSomething(String arg) {
        System.out.println("SimpleProxy something " + arg);
        anInterface.doSomething();
    }
}
