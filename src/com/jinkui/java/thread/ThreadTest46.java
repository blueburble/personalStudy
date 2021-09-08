package com.jinkui.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest46 {

    public static void main(String[] args) {
        Service s = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                s.method();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(runnable);

        thread2.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //即使調用了 也沒能真正終端
        thread2.interrupt();
    }

    static class Service {
        private static Lock lock = new ReentrantLock();

        public void method(){
            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "------" + "begin Lock");
                for(int i = 0; i < Integer.MAX_VALUE; i++){
                    new StringBuilder();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "------" + "end Lock");
            }

        }

    }

}
