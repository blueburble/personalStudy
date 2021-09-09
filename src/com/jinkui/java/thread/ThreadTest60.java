package com.jinkui.java.thread;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest60 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    static void sm(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "lock___");
            System.out.println("是否有线程正在等待当前线程"+ lock.hasWaiters(condition) + "总个数是" + lock.getWaitQueueLength(condition));
            condition.await(new Random().nextInt(1000), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("unlock时"+ lock.hasWaiters(condition) + "总个数是" + lock.getWaitQueueLength(condition));
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ThreadTest60.sm();
            }
        };

        for(int i = 0; i < 10; i ++){
            new Thread(runnable).start();
        }
    }


}
