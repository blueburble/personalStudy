package com.jinkui.java.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest44 {
    private static Lock lock = new ReentrantLock();

    public static void sm1(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "METHOD1" + "___" +  System.currentTimeMillis());
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void sm2(){

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "METHOD2" + "___" +  System.currentTimeMillis());
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> sm1()).start();
        new Thread(() -> sm2()).start();
        new Thread(() -> sm1()).start();
        new Thread(() -> sm2()).start();
        new Thread(() -> sm1()).start();
        new Thread(() -> sm2()).start();
    }
}
