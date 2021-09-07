package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest30 {

    private static final Object lock = new Object();

    public static void main(String[] args){
        Thread thread = new Thread(() ->{
            synchronized (lock){
                System.out.println("進入1綫程");
                try {
                    lock.wait();
                    System.out.println("等dai結束");
                } catch (InterruptedException e) {
                    System.out.println("綫程中止");
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

}
