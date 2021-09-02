package com.jinkui.java.thread;

public class ThreadTest9 {

    public static void main(String[] args){
        My6Thread   t1 = new My6Thread ();
        t1.start();

        for(int i = 0; i< 100; i++){
            System.out.println("mainThread ==>" + i);
        }
        t1.interrupt();
    }

}


class My6Thread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i< 10000000; i++){
            if(this.isInterrupted()){
                break;
            }
            System.out.println("subThread ==>" + i);
        }

        System.out.println("My6Thrad runed");
    }
}