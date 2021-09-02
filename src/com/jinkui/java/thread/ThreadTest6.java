package com.jinkui.java.thread;

public class ThreadTest6 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "" + Thread.currentThread().getId());
        for(int i = 0; i< 50; i++){
            new My3Thread().start();

        }
    }

}


class My3Thread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "" + this.getId());
    }
}