package com.collect.java8.stream.code;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalFlatMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream getStream(){
        return Arrays.stream(elements);
    }

    static void test(String desc, Function<String, Optional<String>> func){
        System.out.println("--(" + desc + "--)");
        for(int i = 0; i < elements.length;){
            System.out.println(getStream().skip(i).findFirst().flatMap(func));
             i++;
        }
    }

    public static void main(String[] args){
        test("ADD brackets", s -> Optional.of("[" + s + "]" ));
        test("Increment", s -> {
            try{
                return Optional.of(Integer.parseInt(s) + 1 + "");
            }catch (NumberFormatException exception){
                return Optional.of(s);
            }
        });
        test("Replace", s -> Optional.of(s.replace("2", "9")));
    }
}
