package com.jinkui.java.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadTest64 {

    static class Service{
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void mm(){
            try {
                readWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + "获得写锁的时间"  + System.currentTimeMillis());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "----释放写锁的时间"  + System.currentTimeMillis());
                readWriteLock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
            Service service = new Service();

            for (int i = 0; i< 5; i++){

                new Thread(() -> service.mm()).start();

            }
    }


}
