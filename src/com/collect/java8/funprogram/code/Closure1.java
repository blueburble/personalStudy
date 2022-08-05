package com.collect.java8.funprogram.code;

import java.util.function.IntSupplier;

public class Closure1 {

    int i;

    IntSupplier makeFun(int num){
        return () -> num + i++;
    }


    public static void main(String[] args) {
        Closure1 closure1 = new Closure1();
        IntSupplier supplier = closure1.makeFun(0);
        IntSupplier supplier2 = closure1.makeFun(0);
        IntSupplier supplier3 = closure1.makeFun(0);
        System.out.println(supplier.getAsInt());
        System.out.println(supplier2.getAsInt());
        System.out.println(supplier3.getAsInt());
    }
}
