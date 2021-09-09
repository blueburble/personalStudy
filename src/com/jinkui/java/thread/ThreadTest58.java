package com.jinkui.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest58 {

    public static void main(String[] args) {
        Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        for(int i = 0; i < 10; i++){
            new Thread(runnable).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.notifyMethod();

    }

    static class Service{
        private ReentrantLock reentrantLock = new ReentrantLock();
        private Condition condition = reentrantLock.newCondition();

        public void waitMethod(){
            try{
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() +"----" + "进入等待前 预估等待线程数 " + reentrantLock.getWaitQueueLength(condition));
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }

        public void notifyMethod(){
            try {
                reentrantLock.lock();
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() +"----" + "唤醒所有线程后 " + reentrantLock.getWaitQueueLength(condition));
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}
