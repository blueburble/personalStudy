package com.jinkui.java.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class ThreadTest21 {

    public static void main(String[] args){

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray (10);
        System.out.println(atomicIntegerArray );

        System.out.println(atomicIntegerArray.get(0));
        System.out.println(atomicIntegerArray.get(1));

        atomicIntegerArray.set(0, 10);
        System.out.println(atomicIntegerArray.getAndSet(1, 11));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.addAndGet(0,22));
        System.out.println(atomicIntegerArray.getAndSet(1,33));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.compareAndSet(0, 32, 222));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.compareAndSet(1, 44, 6666));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.incrementAndGet(1));
        System.out.println(atomicIntegerArray.getAndIncrement(1));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.decrementAndGet(0));
        System.out.println(atomicIntegerArray.getAndDecrement(0));
        System.out.println(atomicIntegerArray);
    }

}
