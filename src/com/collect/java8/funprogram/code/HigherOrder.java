package com.collect.java8.funprogram.code;

import java.util.function.Function;
import java.util.function.Supplier;

public class HigherOrder {

    static FunOrder prouce(){
        return s -> s.toUpperCase();
    }

    public static void main(String[] args){
        FunOrder f = prouce();
        System.out.println(f.apply("yelling"));
    }
}

interface FunOrder extends Function<String, String>{

}
