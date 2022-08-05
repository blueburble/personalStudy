package com.collect.java8.generics.code;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {

    public static <T> List<T> makeList(T... args){
        List<T> result = new ArrayList<>();
        for(T temp : args){
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args){
        List<String> ls = makeList("A");
        List<String> c = makeList("Hello world".split(""));
        System.out.println(ls);
        System.out.println(c);
    }
}
