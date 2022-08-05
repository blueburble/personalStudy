package com.collect.java8.stream.code;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Optionals {
    static void basics(Optional<String> optString){
        if(optString.isPresent()){
            System.out.println(optString.isPresent());
        }else{
            System.out.println("Nothing inside");
        }
    }

    static void isPresent(Optional<String> optString){
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString){
        System.out.println(optString.orElse("NADA"));
    }

    static void orElseGet(Optional<String> optString){
        System.out.println(optString.orElseGet(()-> "UNknow"));
    }

    static void orElseThrow(Optional<String> optString){
        try{
            System.out.println(optString.orElseThrow(() -> new Exception("non")));
        }catch (Exception e){
            System.out.println("catch Exception");
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos){
        System.out.println("===" + testName + "===");
        cos.accept(Stream.of("Epithers").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args){
        test("basics", Optionals::basics);
        test("basics2", Optionals::isPresent);
        test("basics3", Optionals::orElse);
        test("basics4", Optionals::orElseGet);
        test("basics5", Optionals::orElseThrow);

    }
}
