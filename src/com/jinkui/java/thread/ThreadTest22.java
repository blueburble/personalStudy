package com.jinkui.java.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class ThreadTest22 {
        public static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

        public static void main(String[] args) throws InterruptedException {
            Thread[] threads = new Thread[10];
            for(int i = 0; i < threads.length; i++){
                threads[i] = new AddThread();
            }

            for(Thread thread : threads){
                thread.start();
            }

            for(Thread thread : threads){
                thread.join();
            }

            System.out.println(atomicIntegerArray);
        }




        static class AddThread extends  Thread{
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    for(int j = 0; j< atomicIntegerArray.length(); j++){
                        atomicIntegerArray.getAndIncrement(j);
                    }
                }
            }
        }
}
