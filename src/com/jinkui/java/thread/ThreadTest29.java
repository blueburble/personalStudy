package com.jinkui.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadTest29 {

    public static void main(String[] args){
        List<Integer>  array = new ArrayList<>();

        Thread thread1 = new Thread(()->{
            synchronized (array){
                if(array.size() != 5){
                    System.out.println("线程1開始等待");
                    try {
                        array.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1结束等待");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (array){
                for(int i = 0; i< 10; i++){
                    array.add(i);
                  System.out.println("线程2添加了第" + i + "個元素" );

                  if(array.size() >5){
                     array.notify();
                  }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        });

        thread1.start();
        //
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

    }


}
