package com.jinkui.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest56 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void m1(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "--------" +lock.getHoldCount());
            m2();
         }finally {
            lock.unlock();
        }
    }

    public static void m2(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "====" +lock.getHoldCount());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m1();
    }
}
