package com.collect.java8.generics.code;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Suppliers {

    public static <T, C extends Collection<T>> C fill(C coll, Supplier<T> gen, int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(coll::add);
        return coll;
    }
}
