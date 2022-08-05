package com.collect.java8.funprogram.code;

import java.util.function.*;

public class CounsumeFunction {

    static Two Consume(Function<One, Two> oneTwoFunction){
        return oneTwoFunction.apply(new One());
    };


    public static void main(String[] args){
            Two two = Consume(one -> new Two());
    }
}

class One{

}

class Two{

}
