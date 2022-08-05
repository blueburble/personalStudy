package com.collect.java8.generics.code;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class BasicSupplier <T> implements Supplier<T> {

    private Class<T> type;

    public BasicSupplier(Class<T> type){
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> BasicSupplier createSupplier(Class<T> type){
        return new BasicSupplier(type);
    }

    public static void main(String[] args){
        Stream.generate(createSupplier(CountedObject.class)).limit(7).forEach(System.out::println);
    }
}

class CountedObject{
    private static long counter = 0;
    private final long id = counter++;

    public long id(){
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject{" +
                "id=" + id +
                '}';
    }
}
