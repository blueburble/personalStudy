package com.collect.java8.funprogram.code;

import java.util.function.Function;

public class TransformFunction {

    static Function<I, K> transform(Function<I, O> in){
        return in.andThen(o -> {
            System.out.println("JJJ");
            return new K();
        });
    }

    static Function<I,O> transform2(Function<I, O> in){
        return in.compose(i -> {
            System.out.println("before");
            return i;
        });
    }

    public static void main(String[] args){
        Function<I, K> f2 = transform(i ->{
            System.out.println(i);
            return new O();
        });
        K k = f2.apply(new I());
        transform2(i ->{
            System.out.println(i);
            return new O();
        }).apply(new I());
    }

}

class I{
    @Override
    public String toString() {
        return "I";
    }
}


class O{
    @Override
    public String toString() {
        return "O";
    }
}

class K{

    }