package com.jinkui.java.Stream;

import java.util.Arrays;

public class ArrayStreams {
    public static void main(String[] args){
        Arrays.stream(new double[] {3.1415936, 2.718, 1.618}).forEach(System.out::println);

        Arrays.stream(new int[]{1,3,5}).forEach(System.out::println);
    }
}
