package com.jinkui.java.Stream;

import java.util.*;

public class CollectionStream {
    public static void main(String[] args){
        Set<String>  w = new HashSet<>(Arrays.asList("It is a wonderful day for a pay".split(" ")));
        w.stream().map(x -> x+ "").forEach(System.out::print);

        Map<String,Double> m = new HashMap<>();
        m.put("pi", 3.1415);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).forEach(System.out::println);
    }
}
