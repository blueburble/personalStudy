package com.jinkui.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest18 {

    /**
     * violate 不具备 原子性
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        for(int j = 0; j < 10000; j++){
            new ThreadTest17.MyThread12().start();
        }
        Thread.sleep(1000);
        System.out.println(MyThread12.atomicInteger.get());
    }

    static class MyThread12 extends Thread{
        public static AtomicInteger atomicInteger = new AtomicInteger();

        public static  void countAdd(){
            for(int i = 0; i< 10000; i++){
                atomicInteger.getAndIncrement();
            }
            System.out.println(atomicInteger.get());
        }

        @Override
        public void run() {
            countAdd();
        }
    }
}
