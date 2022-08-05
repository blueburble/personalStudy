package com.wildom.day1;

public class Callbacks {
    public static void main(String[] args) {
        Calleel c1 = new Calleel();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallBackReference());
        caller1.go();
        caller1.go();
        caller1.go();
        caller2.go();
    }


}

interface  Incrementable{
    void increment();
}

class Calleel implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment(){
        System.out.println("OTHER OPERATION");
    }

    static void f(MyIncrement mi){
        mi.increment();
    }
}

class Callee2 extends MyIncrement{
    private  int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallBackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callBackReference;
    Caller(Incrementable incrementable){
        this.callBackReference = incrementable;
    }
    void go(){
        callBackReference.increment();
    }
}

