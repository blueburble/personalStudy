package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest68 {
    public static void main(String[] args) {
            ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

            ThreadGroup myGroup1 = new ThreadGroup("group1");
            ThreadGroup myGroup2 = new ThreadGroup(mainGroup, "group2");

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread());
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            new Thread(r, "t1").start();
            new Thread(myGroup1, r, "t2").start();
            new Thread(myGroup2, r, "t3").start();


            Thread[] threads = new Thread[mainGroup.activeCount()];

            //复制到参数数组中
            mainGroup.enumerate(threads);

            for(Thread thread: threads){
                System.out.println("main    输出" +thread);
            }

            System.out.println("-------------------------------------------");

            //复制到参数数组中
            mainGroup.enumerate(threads, false);

            for(Thread thread: threads){
                System.out.println("main    输出" +thread);
            }

            ThreadGroup[] threadGroups = new ThreadGroup[mainGroup.activeGroupCount()];

            mainGroup.enumerate(threadGroups);

            for(ThreadGroup threadGroup: threadGroups){
                System.out.println(threadGroup);
            }
    }
}
