package com.jinkui.java.Stream;

import java.util.Random;
import java.util.stream.Stream;

public class RandomGenerates {
    public static <T>  void show(Stream<T> stream){
        stream.limit(4).forEach(System.out::println);
        System.out.println("++++++++");
    }

    public static void main(String[] args){
        Random rand = new Random(47);
        show(rand.ints().boxed());
        show(rand.longs().boxed());
    }
}
