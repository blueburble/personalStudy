package com.collect.java8.stream.code;

import com.jinkui.java.Stream.Bubble;

import java.util.Arrays;
import java.util.List;

public class CollectionToStream {
    public static void main(String[] args){
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        bubbles.stream().mapToInt(a -> a.i).forEach(System.out::println);
    }
}
