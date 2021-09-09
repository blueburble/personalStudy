package com.jinkui.java.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  判断锁是否被当前
 *
 */
public class ThreadTest62 {

    static ReentrantLock reentrantLock = new ReentrantLock();

    static void sm(){
        try{
            System.out.println("子线程中 1"   + reentrantLock.isLocked());
            reentrantLock.lock();
            System.out.println("子线程中 2"   + reentrantLock.isLocked());
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(reentrantLock.isHeldByCurrentThread()){
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("main 中 1"   + reentrantLock.isLocked());

        new Thread(() -> sm()).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main 中 2" + reentrantLock.isLocked());
    }


}
