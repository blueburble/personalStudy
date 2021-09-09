package com.jinkui.java.thread;


import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ThreadTest61 {
    static class Service{
        private ReentrantLock lock;

        public Service(boolean isFair){
            this.lock = new ReentrantLock(isFair);
        }

        public void serviceMethod(){
            try {
                System.out.println("是否公平锁" + "----------" + lock.isFair() +  "调用Lock 前是否持有锁" + lock.isHeldByCurrentThread());
                lock.lock();
                System.out.println(Thread.currentThread().getName() +  "调用Lock 后是否持有锁" + lock.isHeldByCurrentThread());
            }finally {
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }

        public static void main(String[] args) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int num = new Random().nextInt();
                    new Service(num % 2 == 0 ? true : false).serviceMethod();
                }
            };
            for(int i = 0; i < 30; i++){
                new Thread(runnable).start();
            }
        }
    }
}
