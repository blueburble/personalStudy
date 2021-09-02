package com.jinkui.java.thread;

public class ThreadTest5 {
    public static void main(String[] args) throws InterruptedException  {
        My2Thread my2Thread = new My2Thread();
        System.out.println("当前线程存活状态" + my2Thread.isAlive());
        my2Thread.start();
        Thread.sleep(100);
        System.out.println("当前线程存活状态" + my2Thread.isAlive());
    }
}

class My2Thread extends Thread{
    @Override
    public void run() {
        System.out.println("当前线程存活状态" + this.isAlive());
    }
}
