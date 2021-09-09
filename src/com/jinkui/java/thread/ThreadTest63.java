package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadTest63 {

    static class Service{
        static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        public void read(){
            try{
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "___-获得读锁" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readWriteLock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {

        Service service = new Service();

        for(int i = 0; i< 5; i++){
            new Thread(() -> service.read()).start();
        }

    }


}
