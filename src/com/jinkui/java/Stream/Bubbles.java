package com.jinkui.java.Stream;

import java.util.stream.Stream;

public class Bubbles {
    public static void main(String[] args){
        Stream.generate(Bubble::bubble).limit(5).forEach(System.out::println);
    }
}
