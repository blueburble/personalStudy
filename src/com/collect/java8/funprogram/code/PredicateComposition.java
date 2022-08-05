package com.collect.java8.funprogram.code;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateComposition {

    static Predicate<String> p1 = s -> s.contains("1"),
    p2 = s->s.length() < 6,
    p3 = s -> s.contains("2"),
    p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args){
        Stream.of("11111","44444","13","22222","12").filter(p4::test).forEach(System.out::println);
    }

}
