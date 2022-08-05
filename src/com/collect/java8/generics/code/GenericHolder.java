package com.collect.java8.generics.code;

public class GenericHolder<T> {
    private T a;
    public GenericHolder(){

    }
    public void set(T a){
        this.a = a;
    }
    public T get(){
        return a;
    }

    public static void main(String[] args){
        GenericHolder<Integer> genericHolder = new GenericHolder<>();
        genericHolder.set(new Integer(1));
        /*genericHolder.set("!5");*/
        System.out.println(genericHolder.get());
    }
}
