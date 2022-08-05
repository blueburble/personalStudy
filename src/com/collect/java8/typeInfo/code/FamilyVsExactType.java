package com.collect.java8.typeInfo.code;

public class FamilyVsExactType {
    static void test(Object x){
        System.out.println(x.getClass());
        System.out.println(x instanceof  Base);
        System.out.println(x instanceof Derived);
        System.out.println(Base.class.isInstance(x));
        System.out.println(Derived.class.isInstance(x));
        System.out.println(x.getClass() == Base.class);
        System.out.println(x.getClass() == Derived.class);
        System.out.println(x.getClass().equals(Base.class));
        System.out.println(x.getClass().equals(Derived.class));

        System.out.println("");
    }

    public static void main(String[] args){
        test(new Base());
        test(new Derived());
    }
}

class Base{}

class Derived extends Base {}
