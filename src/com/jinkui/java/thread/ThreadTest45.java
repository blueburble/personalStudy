package com.jinkui.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest45 {

    public static void main(String[] args) {
        new SubThread().start();
        new SubThread().start();
        new SubThread().start();
    }

    static class SubThread extends Thread{
        public  static Lock lock = new ReentrantLock();
        public static int num = 0;
        @Override
        public void run() {
            for(int i = 0 ; i < 10000;  i++){
                try {
                    lock.lock();
                    lock.lock();
                    num++;
                    System.out.println(Thread.currentThread().getName() + "-----" + num);
                }finally {
                    lock.unlock();
                    lock.unlock();
                }
            }
        }
    }
}
