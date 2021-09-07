package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest28 {
    public static void main(String[] args){
        String lock = "hello";
        Thread thread1 = new Thread(()->{
            synchronized (lock){
                System.out.println("thread1开始");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait1结束");
            }
        });
        Thread thread2 = new Thread(() ->{
            synchronized (lock){
                System.out.println("thread2开始");
                    lock.notify();
                System.out.println("notify2结束");
            }
        });
        thread1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
