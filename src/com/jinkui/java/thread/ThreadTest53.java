package com.jinkui.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest53 {

    public static void main(String[] args){

        MyService  service = new MyService();

        new Thread(()->{
            for(int i = 0; i < 100; i++){
                service.printOne();
            }
        }).start();


        new Thread(()->{
            for(int i = 0; i < 100; i++){
                service.printTwo();
            }
        }).start();
    }





    static class MyService{
        private  Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        private boolean flag = true;   //标志

        private void printOne(){
            try {
                lock.lock();
                while (flag){
                    System.out.println(Thread.currentThread().getName() + "_____waiting");
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + "---------------");
                flag = true;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void printTwo(){
            try {
                lock.lock();
                while (!flag){
                    System.out.println(Thread.currentThread().getName() + "_____waiting");
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + "*******");
                flag = false;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
