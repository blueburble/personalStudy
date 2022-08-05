package com.collect.java8.typeInfo.code;

public class InterfaceViolation {
    public static void main(String[] args){
        A a = new B();
        a.f();
        System.out.println(a.getClass().getSimpleName());
        if(a instanceof  B){
            B b = (B) a;
            b.g();
        }
    }
}


class B implements A{

    @Override
    public void f() {

    }

    public void g(){

    }
}


