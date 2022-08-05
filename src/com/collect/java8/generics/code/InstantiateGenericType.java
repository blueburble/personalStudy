package com.collect.java8.generics.code;

import java.util.function.Supplier;

public class InstantiateGenericType {

    public static void main(String[] args){
        ClassAsFactory<Employee> fe  = new ClassAsFactory<>(Employee.class);
        System.out.println(fe.get());
        ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        fi.get();
    }

}


class ClassAsFactory<T> implements Supplier<T> {
    Class <T> kind;

    ClassAsFactory(Class<T> kind){
        this.kind = kind;;
    }

    @Override
    public T get() {
        try {
            return kind.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}

class Employee{
    @Override
    public String toString() {
        return "Employee";
    }
}

