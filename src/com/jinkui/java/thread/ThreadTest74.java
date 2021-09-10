package com.jinkui.java.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池计划任务
 */
public class ThreadTest74 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        //在延迟两秒后执行任务
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
            }
        }, 2 , TimeUnit.SECONDS);

      /*  //固定的频率执行任务     如果任务时间超过间隔时间    任务执行完马上执行下一个
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3 , 1 , TimeUnit.SECONDS);*/

        //固定的频率执行任务     如果任务时间超过间隔时间    任务执行完固定间隔后马上执行下一个
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3 , 1 , TimeUnit.SECONDS);
    }

}
