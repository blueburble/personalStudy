package com.java8.fp;

public class UnboundMethodReference {

    public static void main(String[] args) {
      /*  MakeString make = X::f;*/
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));
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
    String transform(X x);
}

