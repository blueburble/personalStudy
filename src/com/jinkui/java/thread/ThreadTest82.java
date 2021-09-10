package com.jinkui.java.thread;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ThreadTest82 {

    //计算数列的和 需要返回结果
    private static class CountTask extends RecursiveTask<Long>{

        private static final int THRESHOLD = 10000;    //数据规模阈值


        private long start;
        private long end;

        public CountTask(long start, long end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            //判断任务是否需要继续分解
            if(end  - start < THRESHOLD){
                for(long i = start; i < end; i++){
                    sum += i;
                }
            }else {
                //约定每次分为100份数据
                long step = (start  + end)/100;

            }

            return null;
        }
    }
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();


    }
}
