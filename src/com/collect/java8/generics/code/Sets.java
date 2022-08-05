package com.collect.java8.generics.code;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public  static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> temp = new HashSet<>(a);
        temp.addAll(b);
        return temp;
    }


}
