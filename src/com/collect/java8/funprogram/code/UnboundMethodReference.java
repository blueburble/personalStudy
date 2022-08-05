package com.collect.java8.funprogram.code;

public class UnboundMethodReference {
    public static void main(String[] args) {
/*        MakeString makeString = X::f;*/
        Transform sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }
}

class X{
    String f(){
        return "x::f()";
    }
}

interface MakeString{
    String make();
}

interface Transform{
    String transform(X x);
}
