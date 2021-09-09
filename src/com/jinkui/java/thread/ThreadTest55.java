package com.jinkui.java.thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 */
public class ThreadTest55 {
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        reentrantLock.lock();
                        System.out.println(Thread.currentThread().getName() + "获得了锁");
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }
}