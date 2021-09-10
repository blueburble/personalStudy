package com.jinkui.java.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest80 {

    private static class DividedTask implements  Runnable{

        private int x;
        private int y;

        public DividedTask(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            System.out.println("X / Y = " + x/y);
        }
    }
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS,new SynchronousQueue<>());

        for(int i = 0; i< 5; i++){
//            threadPoolExecutor.submit(new DividedTask(10, i));
            threadPoolExecutor.execute(new DividedTask(10, i));
        }
    }
}
