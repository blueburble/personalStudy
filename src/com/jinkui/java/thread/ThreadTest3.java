package com.jinkui.java.thread;

public class ThreadTest3 {
    public static void main(String[] args){
        System.out.println("main当前线程" + Thread.currentThread().getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sub当前线程" + Thread.currentThread().getName());
            }
        });

        thread.start();
    }
}
