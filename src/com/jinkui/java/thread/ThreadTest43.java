package com.jinkui.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest43 {

    static Lock  lock = new ReentrantLock();

    public static void m(){
        //獲得鎖
        lock.lock();
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "------" + i);
        }
        //釋放鎖
        lock.unlock();
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                m();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
