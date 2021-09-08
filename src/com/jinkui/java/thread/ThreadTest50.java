package com.jinkui.java.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest50 {
    public static void main(String[] args) {
            IntLock intLock1 = new IntLock(1);
            IntLock intLock2 = new IntLock(2);

            new Thread(intLock1).start();
            new Thread(intLock2).start();
    }


    static class IntLock implements Runnable{
        private static ReentrantLock lock1  = new ReentrantLock();
        private static ReentrantLock lock2  = new ReentrantLock();
        private int lockNum;

        public IntLock(int num){
            this.lockNum = num;
        }

        @Override
        public void run() {
            if(lockNum % 2 == 0){
                while (true){
                    try {
                        if(lock1.tryLock()){
                            System.out.println(Thread.currentThread().getName() + "獲得鎖1 還昂獲得鎖2");
                            Thread.sleep(new Random().nextInt(100));
                        }
                        try {
                            if(lock2.tryLock()){
                                System.out.println(Thread.currentThread().getName() + "同时獲得锁1和 鎖2");
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if(lock2.isHeldByCurrentThread()){
                                lock2.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if(lock1.isHeldByCurrentThread()){
                            lock1.unlock();
                        }
                    }
                }
            }else {
                while (true){
                    try {
                        if(lock2.tryLock()){
                            System.out.println(Thread.currentThread().getName() + "獲得鎖1 還昂獲得鎖2");
                            Thread.sleep(new Random().nextInt(100));
                        }
                        try {
                            if(lock1.tryLock()){
                                System.out.println(Thread.currentThread().getName() + "同时獲得锁2和 鎖1");
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if(lock1.isHeldByCurrentThread()){
                                lock1.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if(lock2.isHeldByCurrentThread()){
                            lock2.unlock();
                        }
                    }
                }
                }
            }
        }
}
