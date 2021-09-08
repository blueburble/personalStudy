package com.jinkui.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest49 {

    static class Service{
        static ReentrantLock reentrantLock = new ReentrantLock();
        public void serviceMethod(){
            try {
                if(reentrantLock.tryLock()){
                    System.out.println(Thread.currentThread().getName() + "獲得鎖定");
                    Thread.sleep(5000);
                }else{
                    System.out.println(Thread.currentThread().getName() + "沒有獲得鎖");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "釋放鎖");
            }
        }
    }

    public static void main(String[] args){
        Service service = new Service();
        Thread thread1 = new Thread(() -> service.serviceMethod());
        Thread thread2 = new Thread(() -> service.serviceMethod());
        thread1.start();
        thread2.start();
    }


}
