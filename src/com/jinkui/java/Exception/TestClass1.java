package com.jinkui.java.Exception;

public class TestClass1 {
    public static void f() throws SimpleException{
        System.out.println("Throw Exception from f()");
        throw new SimpleException();
    }

    public static void main(String[] args){
        try{
            TestClass1.f();
        }catch(SimpleException e){
            e.printStackTrace();
        }

    }
}


class SimpleException extends Exception{

}