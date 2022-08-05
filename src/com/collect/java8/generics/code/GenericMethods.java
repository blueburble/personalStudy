package com.collect.java8.generics.code;

public class GenericMethods<A> {

        A name;


        public static <T> void println(T t){
            System.out.println(t.getClass().getName());
        }

        public static void main(String[] args){
      /*      GenericMethods methods = new GenericMethods();*/
            GenericMethods.println(1);
            GenericMethods.println("2");
        }
}
