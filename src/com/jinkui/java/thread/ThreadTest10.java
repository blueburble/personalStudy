package com.jinkui.java.thread;

public class ThreadTest10 {

    public static void main(String[] args){
        Runnable runnable = () ->{
            while(true){
                System.out.println("I am Studying.......");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        for(int i = 0; i < 100; i++){
            System.out.println("main ==> " + i);
        }
    }
}
