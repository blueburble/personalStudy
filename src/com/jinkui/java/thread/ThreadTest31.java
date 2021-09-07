package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest31 {
    public static void main(String[] args){
        Object obj = new Object();
        new MyThread7899(obj).start();
        new MyThread7899(obj).start();
        new MyThread7899(obj).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj){
            obj.notifyAll();
        }
    }

    static class MyThread7899 extends  Thread{
        private Object lock;
        public MyThread7899(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "开始wait");
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "结束wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
