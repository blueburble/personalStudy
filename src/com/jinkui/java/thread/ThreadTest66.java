package com.jinkui.java.thread;

public class ThreadTest66 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup());


        ThreadGroup threadGroup = new ThreadGroup("group1");
        System.out.println(threadGroup);

        ThreadGroup threadGroup2 = new ThreadGroup(Thread.currentThread().getThreadGroup(), "group2");
        System.out.println(threadGroup2);

        System.out.println(threadGroup.getParent());
        System.out.println(threadGroup2.getParent());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread thread = new Thread(runnable);
        System.out.println(thread);

        Thread thread2 =  new Thread(threadGroup, runnable, "t2");
        System.out.println(thread2);
    }
}
