package com.collect.java8.generics.code;

public class ClassTypeCapture<T> {
    Class<T> kind;
    ClassTypeCapture(Class<T> T){
        this.kind = T;
    }

    private boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args){
        ClassTypeCapture<Building> cttl = new ClassTypeCapture<>(Building.class);
        System.out.println(cttl.f(new Building()));
        System.out.println(cttl.f(new House()));
    }
}


class Building{

}

class House extends Building{

}