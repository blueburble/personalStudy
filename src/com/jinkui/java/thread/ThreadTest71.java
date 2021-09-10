package com.jinkui.java.thread;

import java.nio.charset.StandardCharsets;

public class ThreadTest71 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "产生了" + e.getMessage() + "异常");
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println(Thread.currentThread().getName() + "开始运行");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(12%0);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               String  txt = null;
               System.out.println(txt.length());
            }
        });

        t1.start();
        t2.start();
    }
}
