package com.jinkui.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest52 {

    public static void main(String[] args) {
        Service service = new Service();
        Thread thread1 = new Thread(() -> service.awaitMethodA());
        Thread thread2 = new Thread(() -> service.awaitMethodB());
        thread1.start();
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.signalA();
        service.signalB();
    }


    static class Service{
        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void awaitMethodA(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "BEGIN WAIT A");
                Thread.sleep(1000);
                conditionA.await();
                System.out.println(Thread.currentThread().getName() + "結束等待 A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void awaitMethodB(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "BEGIN WAIT B");
                Thread.sleep(1000);
                conditionB.await();
                System.out.println(Thread.currentThread().getName() + "結束等待 B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signalA(){
            try {
                lock.lock();
                conditionA.signal();
                System.out.println(Thread.currentThread().getName() + "喚醒A");
            } finally {
                lock.unlock();
            }
        }

        public void signalB(){
            try {
                lock.lock();
                conditionB.signal();
                System.out.println(Thread.currentThread().getName() + "唤醒B");
            } finally {
                lock.unlock();
            }
        }
    }
}
