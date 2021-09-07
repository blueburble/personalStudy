package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ThreadTest26 {

    private static AtomicStampedReference<String> atomicStampedReference =
            new AtomicStampedReference<>("abc", 0);

    public static void main(String[] args){

        Thread t1 = new Thread(() ->{
            atomicStampedReference.compareAndSet("abc", "deg", atomicStampedReference.getStamp(), atomicStampedReference.getStamp() +1);

            System.out.println(Thread.currentThread().getName() + atomicStampedReference.getReference());

            atomicStampedReference.compareAndSet("deg", "abc", atomicStampedReference.getStamp(), atomicStampedReference.getStamp() +1);

        });

        Thread t2 = new Thread(() ->{

           /* int timeStamp  = atomicStampedReference.getStamp();*/

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int timeStamp  = atomicStampedReference.getStamp();

            atomicStampedReference.compareAndSet("abc", "ggg", timeStamp, atomicStampedReference.getStamp() +1);

            System.out.println(Thread.currentThread().getName() + atomicStampedReference.getReference());

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicStampedReference.getReference());

    }



}
