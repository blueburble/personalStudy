package com.jinkui.java.thread;

public class ThreadTest7 {
    public static void main(String[] args){

        new My4Thread().start();

        long beginTime = System.currentTimeMillis();

        long sum = 0;
        for(int i = 1; i < 599999900; i++){
            sum += i;
        }

        System.out.println("'main方法 用時 "+ (System.currentTimeMillis() - beginTime));
    }

}

class My4Thread extends Thread{
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        System.out.println(this.getName() + this.getId());

        long sum = 0;
        for(int i = 1; i <  599999900; i++){
            sum += i;
            Thread.yield();
        }

        System.out.println("'run方法 用時 " + (System.currentTimeMillis() - beginTime));
    }
}
