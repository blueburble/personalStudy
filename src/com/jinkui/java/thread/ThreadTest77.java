package com.jinkui.java.thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadTest77 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int num = new Random().nextInt(10);
                System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getId() + "睡眠" + num + "秒");
                try {
                    TimeUnit.SECONDS.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService  executorService = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                System.out.println("创建了线程" +t);
                return t;
            }
        });

        for(int i = 0; i  < 15; i++){
            executorService.submit(new Thread(runnable));
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
