package com.jinkui.java.lambda;

public class RunnableReference {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();
        new Thread( () -> System.out.println("hello lambda")).start();

        new Thread(Go::go).start();
    }
}

class Go{
    static void go() {
        System.out.println("GO::go");
    }
}