package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest57 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                mm();
            }
        };
        for(int i = 0; i < 10; i++){
            new Thread(r).start();
        }
    }

    static ReentrantLock MYLock = new ReentrantLock();

    public static void mm(){
        try {
            MYLock.lock();
            System.out.println(Thread.currentThread().getName() +    "---------> 等待的线程" + MYLock.getQueueLength());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            MYLock.unlock();
        }
    }
}
