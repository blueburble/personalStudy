package com.jinkui.java.thread;

public class ThreadTest14 {

    public static void main(String[] args){

        ThreadTest14 threadTest14 = new ThreadTest14();
        new Thread(()->  threadTest14.generalPrintfLoop()).start();
        new Thread(()->  ThreadTest14.printLoop()).start();
    }



    static synchronized void printLoop(){
        for(int i = 0; i < 1000; i ++){
            System.out.println(Thread.currentThread().getName() + "----->" + i);
        }
    }

    void generalPrintfLoop(){
        synchronized (ThreadTest14.class) {
            for(int i = 0; i < 1000; i ++){
                System.out.println(Thread.currentThread().getName() + "----->" + i);
                if(500 == i){
                    //异常自动释放锁
                    Integer.parseInt("Exception Test");
                }
            }
        }
    }
}
