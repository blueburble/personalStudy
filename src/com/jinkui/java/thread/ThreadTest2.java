package com.jinkui.java.thread;

public class ThreadTest2 {

    public static void main(String[] args){
        new Thread(new MyRunable()).start();
        new Thread(new MyRunable()).start();
        new Thread(new MyRunable()).start();
    }
}


class MyRunable implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(i);
        }
    }
}
