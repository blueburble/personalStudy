package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS ABA 問題
 */
public class ThreadTest25 {

    private static AtomicReference<String> AUTO = new AtomicReference<>("abs");

    public static void main(String[] args){

        Thread myThread1 = new Thread(()->{
            System.out.println(AUTO.compareAndSet("abs", "dfg"));
            System.out.println(AUTO.compareAndSet("dfg", "abs"));
        });

        Thread myThread2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(AUTO.compareAndSet("abs", "VBN"));
        });

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(AUTO.get());
    }


}
