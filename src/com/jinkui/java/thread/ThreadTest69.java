package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest69 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread() + "开始循环");
                while(! Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + "-------");
                }
                System.out.println("当前线程"+Thread.currentThread() + "循环结束");
            }
        };

        ThreadGroup threadGroup = new ThreadGroup("m1");

        for(int i = 0; i <5 ; i++){
            new Thread(threadGroup, runnable).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadGroup.interrupt();
    }
}
