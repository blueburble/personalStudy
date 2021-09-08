package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest48 {
    static class TimeLock extends Thread{
        static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if(lock.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()  + "获得锁");
                    Thread.sleep(2000);
                }else {
                    System.out.println(Thread.currentThread().getName() + "没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new TimeLock();
        Thread t2 = new TimeLock();
        t1.start();
        t2.start();
    }

}



