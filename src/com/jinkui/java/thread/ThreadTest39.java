package com.jinkui.java.thread;

public class ThreadTest39 {

    static ThreadLocal threadLocal = new ThreadLocal();

    static class SubThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 20; i++){
                threadLocal.set(Thread.currentThread().getName() + "_" + i);
                System.out.println(Thread.currentThread().getName() + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
            SubThread subThread1 = new SubThread();
            SubThread subThread2 = new SubThread();
            subThread1.start();
            subThread2.start();
    }
}
