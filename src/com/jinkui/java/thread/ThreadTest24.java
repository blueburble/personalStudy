package com.jinkui.java.thread;

import java.util.concurrent.atomic.AtomicReference;

public class ThreadTest24 {
    private static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args){

        for(int i = 0; i < 100; i ++){
            new Thread(() ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(atomicReference.compareAndSet("abc", "def")){
                    System.out.println(Thread.currentThread().getName() + "abc -> def");
                }
            }).start();
        }

        for(int i = 0; i < 100; i ++){
            new Thread(() ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(atomicReference.compareAndSet("def", "abc")){
                    System.out.println(Thread.currentThread().getName() + "def -> abc");
                }
            }).start();
        }

        System.out.println(atomicReference.get());
    }

}
