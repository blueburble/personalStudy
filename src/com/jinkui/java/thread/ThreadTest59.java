package com.jinkui.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest59 {

    static ReentrantLock Lock = new ReentrantLock();

    public static void waitMethod(){
        try {
            Lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            Lock.unlock();
        }
    }

    public static void main(String[] args) {


        Runnable r = new Runnable() {
            @Override
            public void run() {
                    ThreadTest59.waitMethod();
            }
        };

        Thread[] threads = new Thread[5];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(r);
            threads[i].setName("thread " + i);
            threads[i].start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Lock.hasQueuedThread(threads[0]));
        System.out.println(Lock.hasQueuedThread(threads[1]));
        System.out.println(Lock.hasQueuedThread(threads[2]));
        System.out.println(Lock.hasQueuedThread(threads[3]));
        System.out.println(Lock.hasQueuedThread(threads[4]));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main 线程中" + Lock.hasQueuedThreads());
    }


}
