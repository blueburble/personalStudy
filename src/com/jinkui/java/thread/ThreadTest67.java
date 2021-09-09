package com.jinkui.java.thread;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

public class ThreadTest67 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group = new ThreadGroup("T2"); //默认父线程组是main

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("当前线程" +  Thread.currentThread().getName() );
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(r, "t1").start();
        new Thread(group, r, "t2").start();

        System.out.println("main线程组中的活动线程数量 + "+ threadGroup.activeCount());  //main t1 t2 垃圾回收
        System.out.println("T2线程组中的活动线程数量 + "+ group.activeCount());    // t2

        System.out.println("main线程组中的活动线程组数量 + "+ threadGroup.activeGroupCount());    //goup
        System.out.println("T2线程组中的活动线程组数量 + "+ group.activeGroupCount()); //无

        System.out.println("main线程中的父线程组" + threadGroup.getParent());   //System
        System.out.println("T2线程组中的父线程组 + "+ group.getParent());     //main

        System.out.println("main是否是main的父线程" + threadGroup.parentOf(threadGroup));
        System.out.println("T2线程组中的父线程组 + "+ group.parentOf(group));
        threadGroup.list();
    }
}
