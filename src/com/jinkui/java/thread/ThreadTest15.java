package com.jinkui.java.thread;

/**
 * 死锁  获取锁的顺序不一致 导致出现死锁    解决办法：获得锁的顺序保持一致
 */
public class ThreadTest15 {

    public static void main(String[] args){
            ThreadDie1 td = new ThreadDie1();
            td.setName("a");
            td.start();
            ThreadDie1 yd = new ThreadDie1();
            yd.setName("b");
            yd.start();
        }

    static class ThreadDie1 extends Thread{
        private static Object object1 = new Object();
        private static Object object2 = new Object();
        @Override
        public void run() {
            if("a".equals(Thread.currentThread().getName())){
                synchronized (object1){
                    System.out.println(Thread.currentThread().getName() + "获得Object1");
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName() + "获得Object2");
                    }
                }
            }else{
                synchronized (object1){
                    System.out.println(Thread.currentThread().getName() + "获得Object2");
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName() + "获得Object1");
                    }
                }
            }
        }
    }
}

