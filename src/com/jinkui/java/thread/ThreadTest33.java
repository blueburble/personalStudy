package com.jinkui.java.thread;

/**
 *
 * 通知过早
 */
public class ThreadTest33 {
        private static Boolean isFirst = false;

        public static void main(String[] args){
            final Object obj = new Object();
            Thread thread1 = new Thread(()->{
                synchronized (obj){
                    if(!isFirst){
                        System.out.println("綫程等待開始");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程等待结束");
                    }
                }
            });
            Thread thread2 = new Thread(()->{
                synchronized (obj){
                    isFirst = true;
                    System.out.println("线程唤醒开始");
                    obj.notify();
                    System.out.println("线程唤醒结束");
                }
            });

            thread2.start();

            thread1.start();
        }
}
