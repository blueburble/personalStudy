package com.collect.java8.funprogram.code;

import java.util.function.Function;

//柯里化
public class CurryingAndPartials {

    static String unCreed(String a, String b){
        return a + b;
    }

    public static void main(String args[]){
        Function<String, Function<String, String>> sum = a -> b -> a+b;
        System.out.println(unCreed("Hello", "NIHAO"));
        Function<String, String> bss = sum.apply("Hello");
        System.out.println(bss.apply("NIHAO"));
    }
}
