package com.collect.java8.generics.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FactoryConstraint {

    public static void main(String[] args){
        System.out.println(new Foo2<>(new IntegerFactory()));
        System.out.println(new Foo2<>(new Widget.Factory()));
        System.out.println(new Foo2<>(Fudge::new));
    }

}

class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    public Integer get(){
        return ++i;
    }
}

class Widget{
    private int id;

    Widget(int n){
        id = n;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "id=" + id +
                '}';
    }

    public static class Factory implements Supplier<Widget>{

        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(i++);
        }
    }
}


class Fudge {
    private static int count  = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge{" +
                "n=" + n +
                '}';
    }
}

class Foo2<T>{
    private List<T> x = new ArrayList<>();

    Foo2(Supplier<T> factory){
        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return "Foo2{" +
                "x=" + x +
                '}';
    }
}
