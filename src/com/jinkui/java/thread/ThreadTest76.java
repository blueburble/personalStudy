package com.jinkui.java.thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadTest76 {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                int num = new Random().nextInt(5);
                System.out.println(Thread.currentThread().getName() + " ----" + System.currentTimeMillis() + "开始睡眠" + num + "秒");
                try {
                    TimeUnit.SECONDS.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r + "is discarding");
            }
        });

        for(int i = 0; i< 2000; i++){
            threadPoolExecutor.submit(run);
        }
    }
}
