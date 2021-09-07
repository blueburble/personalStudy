package com.jinkui.java.thread;


/**
 *
 * 等待 通知
 * 等待通知机制的实现
 *
 *
 * wait 立即释放锁
 */
public class ThreadTest27 {

    public static void main(String[] args){
        String txt  = "jinggui";
        //同步代码块开始
        synchronized (txt){
            try {
                //wait 会使的线程等待
                txt.wait();
                System.out.println("wait后面的代码");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("同步代码块后面的代码");

    }
}
