package com.jinkui.java.Stream;
import static java.util.stream.IntStream.*;

public class Ranges {
    public static void main(String[] args){
        int result = 0;
        for(int i = 0; i< 20 ; i ++){
            result += i;
        }
        System.out.println(result);

        result = 0;
        for(int i : range(0, 20).toArray()){
            result += i;
        }

        System.out.println(result);
        System.out.println(range(0, 20).sum());
    }
}
