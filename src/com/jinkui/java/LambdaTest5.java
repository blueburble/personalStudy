package com.jinkui.java;

public class LambdaTest5 {

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous");
            }
        }).start();
        new Thread(() -> System.out.println("lambda")).start();

        new Thread(Go :: go).start();
    }

}


class Go{
    static void go(){
        System.out.println("GO: go");
    }
}