package com.jinkui.java;

public class LambdaTest6 {
    public static void main(String[] args){
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transForm(x));
        System.out.println(x.f());
    }
}

class X{
    String f(){
        return "X::F()";
    }
}

interface MakeString{
    String make();
}

interface TransformX{
    String transForm(X x);
}

