package com.jinkui.java.thread;

import java.util.concurrent.*;

public class ThreadTest81 {

    private static class TreesThreadPool extends ThreadPoolExecutor{

        public TreesThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        //对执行任务包装, 第一个参数执行要执行的任务 第二个参数是exception异常
        public Runnable wrap(Runnable task, Exception e){
            return new Runnable() {
                @Override
                public void run() {
                    try{
                        task.run();
                    }catch (Exception e){
                        e.printStackTrace();
                        throw e;
                    }
                }
            };
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task, new Exception("线程跟踪异常")));
        }

        @Override
        public void execute(Runnable command) {
            super.execute(wrap(command, new Exception("线程跟踪异常")));
        }
    }

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

        TreesThreadPool threadPoolExecutor = new  TreesThreadPool(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS,new SynchronousQueue<>());

        for(int i = 0; i< 5; i++){
          threadPoolExecutor.submit(new DividedTask(10, i));
        }
    }
}
