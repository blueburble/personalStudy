package com.jinkui.java.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadTest41 {

    static class MyThreadLocal extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return new Date();
        }
    }

    /*private static ThreadLocal threadLocal = new ThreadLocal();*/

    private static MyThreadLocal threadLocal = new MyThreadLocal();

    public static void main(String[] args){

        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + threadLocal.get());

                if(null == threadLocal.get()){
                    threadLocal.set(new Date());
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
