package com.jinkui.java.lambda;

public class UnboundMethodReference {

    public static void main(String[] args){

       /* MakeString makeString = X :: f;*/
        TransformX transformX = X :: f;
        X x = new X();
        System.out.println(transformX.transform(x));
        System.out.println(x.f());

    }
}

class X{
    String f(){
        return "X::f()";
    }
}

interface MakeString{
    String make();
}

interface TransformX{
    String transform(X x);
}