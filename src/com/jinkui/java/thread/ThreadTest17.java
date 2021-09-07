package com.jinkui.java.thread;

public class ThreadTest17 {

    /**
     * violate 不具备 原子性
     * @param args
     */
    public static void main(String[] args){
        for(int j = 0; j < 100; j++){
            new MyThread12().start();
        }
    }

    static class MyThread12 extends Thread{
        public static int count = 0;

        public static synchronized void countAdd(){
            for(int i = 0; i< 100; i++){
                count++;
            }
            System.out.println(count);
        }

        @Override
        public void run() {
             countAdd();
        }
    }
}
