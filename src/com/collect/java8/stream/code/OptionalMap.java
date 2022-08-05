package com.collect.java8.stream.code;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalMap {
    static String[] elements = {"12", "14", "18", "", "45"};

    static Stream<String> getStream(){
        return Arrays.stream(elements);
    }

    static void test(String desc, Function<String, String> function){
        System.out.println("----(" +  desc + ")------");
        for(int i = 0; i <= elements.length; i++){
            System.out.println(getStream().skip(i).findFirst().map(function));
        }
    }

    public static void main(String[] args){
        test("aDD BLACKS", s->"[" + "s" + "]");
        test("Increment", s ->{
                try{
                    return Integer.parseInt(s) + 1 + "";
                }catch (NumberFormatException e){
                    return s;
                }
        });
        test("Replace", s ->s.replace("2", "9"));
    }
}
