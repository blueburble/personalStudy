package com.jinkui.java.lambda;

import java.util.ArrayList;
import java.util.Random;

public class CtorReference {
    public static void main(String[] args){
        MakeDogNoArg makeDogNoArg = Dog::new;

        MakeDogSingleArg makeDogSingleArg = Dog::new;

        MakeDogTwoArg makeDogTwoArg = Dog::new;

        ArrayList<Integer> temp = new ArrayList<>();
        System.out.println(makeDogNoArg.makeDog());
        System.out.println(makeDogSingleArg.makeDog("xiaobai"));
        System.out.println(makeDogTwoArg.makeDog("xiaohei", 9));
    }
}


class Dog{
    String name;
    int age = -1;
    Dog() {
        name = "huahua";
    }
    Dog(String name){
        this.name = name;
    }
    Dog(String name, int old){
        this.name = name;
        age = old;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

interface MakeDogNoArg{
    Dog makeDog();
}

interface MakeDogSingleArg{
    Dog makeDog(String name);
}

interface MakeDogTwoArg{
    Dog makeDog(String name, int old);
}