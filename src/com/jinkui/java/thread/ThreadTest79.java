package com.jinkui.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * 扩展线程池
 */
public class ThreadTest79 {

    private static class MyTask implements Runnable{

        String name;

        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "正在被" + Thread.currentThread().getId() + "执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0 , TimeUnit.SECONDS, new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(t.getId() +"准备执行" +((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println(((MyTask)r).name + "执行完成");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for(int i = 0; i < 5; i ++){
            MyTask myTask = new MyTask("Task" + i);
            executorService.execute(myTask);
        }

        executorService.shutdown();
    }
}
