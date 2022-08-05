package com.collect.java8.generics.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FilledList<T> extends ArrayList<T> {

    FilledList(Supplier<T> suppliers, int size){
        Suppliers.fill(this, suppliers, size);
    }

    public FilledList(T t, int size){
        for(int i = 0; i < size; i++){
            this.add(t);
        }
    }

    public static void main(String[] args){
        List<String> list = new FilledList<>("HELLO", 4);
        System.out.println(list);
        List<Integer> ilise = new FilledList<>(() -> 47, 5);
        System.out.println(ilise);
    }
}
