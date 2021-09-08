package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * condition等待与通知
 */
public class ThreadTest51 {
    private static  Lock myLock = new ReentrantLock();
    private static Condition conditon = myLock.newCondition();

    public static void main(String[] args){
        SubThread subThread = new SubThread();
        subThread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            myLock.lock();
            conditon.signal();
        } finally {
            myLock.unlock();
        }
    }

    static class SubThread extends Thread{
        @Override
        public void run() {
            try{
                myLock.lock();
                System.out.println("thread Lock");
                conditon.await();
                System.out.println("thread await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
                System.out.println("thread unLock");
            }
        }
    }

}
