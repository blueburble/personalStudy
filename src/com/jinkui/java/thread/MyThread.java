package com.jinkui.java.thread;

/**
 * 定义一个类 继承thread
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("这是子线程打印的内容");
    }
}
