package com.collect.java8.generics.code;

import com.collect.java8.generics.code.coffee.*;
import org.omg.CORBA.INTERNAL;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {

    public Class<?>[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    public CoffeeSupplier(){

    }

    private int size = 0;

    public CoffeeSupplier(int size){
        this.size = size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee get() {
        try {
            Coffee o = (Coffee) types[rand.nextInt(types.length)].newInstance();
            return o;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        Stream.generate(new CoffeeSupplier()).limit(5).forEach(System.out::println);
        for(Coffee c : new CoffeeSupplier(5)){
            System.out.println(c);
        }
    }
}
