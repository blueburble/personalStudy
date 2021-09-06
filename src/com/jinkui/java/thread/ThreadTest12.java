package com.jinkui.java.thread;

import java.util.Random;

public class ThreadTest12 {
    public static void main(String[] args){
        MyJob mj = new MyJob();
        mj.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mj.cancel();
    }

    static class MyJob extends Thread{
        private boolean isCancel = false;

        @Override
        public void run() {
            while(! isCancel){
                System.out.println("方法执行");
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(isCancel){
                System.out.println("方法被退出");
            }else{
                System.out.println("方法正常执行");
            }
        }

        private  void cancel(){
            this.isCancel = true;
        }
    }
}
