package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadTest65 {

    static class Service{
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void read(){
            try{
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "获得读锁的时间" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "释放读锁的时间" + System.currentTimeMillis());
                readWriteLock.readLock().unlock();
            }
        }

        public void write(){
            try{
                readWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + "获得写锁的时间" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "释放写锁的时间" + System.currentTimeMillis());
                readWriteLock.writeLock().unlock();
            }
        }

    }

    public static void main(String[] args) {
        Service service  = new Service();

        new Thread(() -> service.read()).start();
        new Thread(() -> service.write()).start();
    }

}
