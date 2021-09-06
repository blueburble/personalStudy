package com.jinkui.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest11 {

    public static void main(String[] args){
        MyInt2 myint = new MyInt2();
        for(int i = 1; i< 4; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName() + "     --->       " + myint.getNum());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }
    }

    static class MyInt{
        int num = 0;
        public  int getNum(){
            return num++;
        }
    }

    static class MyInt2{
        AtomicInteger num = new AtomicInteger();
        public int getNum(){
            return num.getAndIncrement();
        }
    }
}


/**
 * 1.原子性
 * 2.不可见性   看不到中间结果
 *
 *
 *
 */