package com.jinkui.java.thread;

public class ThreadTest42 {
    public static void main(String[] args) {

            ThreadTest42 threadTest42 = new ThreadTest42();
            Thread thread = new Thread(()->threadTest42.sm1());
            thread.start();

    }


    public synchronized void sm1(){
        System.out.println("方法1");
        sm2();
    }

    public synchronized void sm2(){
        System.out.println("方法2");
        sm3();
    }

    public synchronized void sm3(){
        System.out.println("方法3");
    }

}
