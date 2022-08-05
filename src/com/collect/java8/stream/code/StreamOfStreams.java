package com.collect.java8.stream.code;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String[] args){
        Stream.of(1,2,3).map(i -> Stream.of("G", "K", "B")).map(e -> e.getClass().getSimpleName()).forEach(System.out::println);

        Stream.of(1,2,3).flatMap(i ->Stream.of("G","K","B")).forEach(System.out ::println);

        Stream.of(1,2,3,4,5).
                flatMapToInt(i ->
                        IntStream.concat(ran.ints(0,100).limit(i), IntStream.of(-1) )
                ).
                forEach(System.out::print);

    }

    static Random ran = new Random(47);
}
