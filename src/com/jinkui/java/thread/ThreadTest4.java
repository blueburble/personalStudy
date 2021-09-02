package com.jinkui.java.thread;

public class ThreadTest4 {
    public static void main(String[] args) throws InterruptedException {
        MySmallThread smallThread = new MySmallThread();
        smallThread.setName("XIAOHONG");
        smallThread.start();

        Thread.sleep(200);

        Thread thread2 = new Thread(smallThread);
        thread2.start();

    }
}

class MySmallThread extends Thread{
    public MySmallThread(){
        System.out.println("构造 方法当前线程" + Thread.currentThread().getName());
        System.out.println("构造方法当前name" + this.getName());
    }
    @Override
    public void run() {
        System.out.println("run 方法当前线程" + Thread.currentThread().getName());
        System.out.println("run 方法当前name" + this.getName());
    }
}