package com.collect.java8.stream.code;

import java.util.Optional;

public class CreatingOptionals {
    static void test(String testName, Optional<String> opt){
        System.out.println("===" + testName + "====");
        System.out.println(opt.orElse("NULL"));
    }

    public static void main(String[] args){
        test("empty", Optional.empty());
        test("of", Optional.of("HHH"));
        try {
            test("ofNull", Optional.of(null));
        }catch (Exception e){

        }

        test("ofNullable", Optional.ofNullable("hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
