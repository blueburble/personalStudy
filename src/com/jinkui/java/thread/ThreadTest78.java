package com.jinkui.java.thread;

import java.util.concurrent.*;

public class ThreadTest78 {

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "线程开始执行" + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        for(int i = 0; i< 30 ; i++){
            poolExecutor.submit(run);

            System.out.println("当前线程池核心线程数" +poolExecutor.getCorePoolSize());

            System.out.println("当前线程池最大线程数" +poolExecutor.getMaximumPoolSize());

            System.out.println("当前线程池大小" +poolExecutor.getPoolSize());

            System.out.println("当前线程收到任务数" +poolExecutor.getTaskCount());

            System.out.println("当前线程池完成任务数" + poolExecutor.getCompletedTaskCount());

            System.out.println("当前线程池等待任务数" + poolExecutor.getQueue().size());

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("------------------------");

            while (poolExecutor.getActiveCount() > 0);{

                System.out.println("当前线程池核心线程数" +poolExecutor.getCorePoolSize());

                System.out.println("当前线程池最大线程数" +poolExecutor.getMaximumPoolSize());

                System.out.println("当前线程池大小" +poolExecutor.getPoolSize());

                System.out.println("当前线程收到任务数" +poolExecutor.getTaskCount());

                System.out.println("当前线程池完成任务数" + poolExecutor.getCompletedTaskCount());

                System.out.println("当前线程池等待任务数" + poolExecutor.getQueue().size());

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
