package com.collect.java8.stream.code;

import java.util.Random;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args){
        Stream.generate(Frobnitz::supply).limit(10).peek(System.out::println).reduce(((f1, f2) -> f1.size < 50 ? f1 : f2)).map(s -> s + "1111").ifPresent(System.out::println);
    }


}

class Frobnitz{
    int size;
    Frobnitz(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "Frobnitz{" +
                "size=" + size +
                '}';
    }

    static Random rand = new Random();
    static final int Bound = 100;
    static Frobnitz supply(){
        return new Frobnitz(rand.nextInt(Bound));
    }
}