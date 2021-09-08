package com.jinkui.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest47 {

    public static void main(String[] args) {
        LockSub lockSub1 = new LockSub(1);
        LockSub lockSub2 = new LockSub(2);
        lockSub1.start();
        lockSub2.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(lockSub1.isAlive()) lockSub1.interrupt();
        if(lockSub2.isAlive()) lockSub2.interrupt();
    }

    static class LockSub extends Thread{
        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();

        private int i;

        public LockSub(int i){
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if(i % 2 == 1){
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "LOCK1 被鎖");
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "LOCK2 被鎖");
                    Thread.sleep(1000);
                }else {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "LOCK2 被鎖");
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "LOCK1 被鎖");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中斷");
                e.printStackTrace();
            } finally {
                if(lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "LOCK1 被釋放");
                if(lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "LOCK2 被釋放");
            }
        }
    }
}
