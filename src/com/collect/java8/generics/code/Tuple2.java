package com.collect.java8.generics.code;

public class Tuple2<A, B>{
    public final A a1;
    public final B b1;

    public Tuple2(A a, B b) {
        this.a1 = a;
        this.b1 = b;
    }

    @Override
    public String toString(){
        return "(" + rep() + ")";
    }

    public String rep(){
        return a1 + "," + b1;
    }
}
