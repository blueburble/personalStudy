package com.jinkui.java.thread;


import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个线程取数据 添加数据 添加完通知
 * 另一个线程取数据 没有数据就等待
 */
public class ThreadTest34 {

    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args){

        Thread th1 = new Thread(() -> add());
        Thread th2 = new Thread(() -> get());

          /*  th1.start();
            th2.start();*/

        th2.start();
        new Thread(() -> get()).start();
        th1.start();


    }

    public static void add(){
        synchronized (list){
            list.add("msg");
            list.notifyAll();
            System.out.println("唤醒结束");
        }
    }

    public static void get(){
        synchronized (list){
            while (list.size() == 0){
                System.out.println("没有数据。。。 等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待结束");
            }
            Object object = list.remove(0);
            System.out.println(object);
        }
    }
}