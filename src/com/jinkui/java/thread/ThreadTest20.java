package com.jinkui.java.thread;

import java.util.Random;

/**
 * 模拟服务器的请求总数,成功数、失败数
 */
public class ThreadTest20 {
        public static void main(String[] args){

            for(int i = 0; i< 10000; i++){
                new Thread(()->{
                    Indicator.getInstance().newRequestReceive();
                    int num = new Random().nextInt();
                    if(num % 2 == 0){
                        Indicator.getInstance().newSuccessCount();
                    }else {
                        Indicator.getInstance().newErrorCount();
                    }
                }).start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Indicator.getInstance().viewAllCount());
            System.out.println(Indicator.getInstance().viewSuccessCount());
            System.out.println(Indicator.getInstance().viewErrorCount());
        }
}
