package com.jinkui.java.thread;

public class ThreadTest32 {

    public static void main(String[] args) {
        new MyThread().start();
    }


    static class MyThread extends  Thread{
        private static Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("thread begin wait");
                try {
                    lock.wait(5000);
                    System.out.println("thread end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread end wait");
            }
        }
    }
}
