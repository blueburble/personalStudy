package com.jinkui.java.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest37 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        Producer producer = new Producer(myStack);
        Consumer consumer = new Consumer(myStack);
        Producer producer1 = new Producer(myStack);
        Consumer consumer1 = new Consumer(myStack);
        Producer producer2 = new Producer(myStack);
        Consumer consumer2 = new Consumer(myStack);
        producer.start();
        consumer.start();
        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();
    }





    static class MyStack {
        private static List list = new ArrayList();
        private static final int Max = 1;
        public synchronized void add(){
            while(list.size() >= Max){
                try {
                    System.out.println(Thread.currentThread().getName() +"生產者等待");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String msg = System.currentTimeMillis() + "_";
            System.out.println(Thread.currentThread().getName() +"創建了數據" + msg);
            list.add(msg);
            this.notifyAll();
        }

        public  synchronized void pop(){
            while(list.size() <= 0){
                try {
                    System.out.println(Thread.currentThread().getName() +"消费者等待");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"取到了數據" + list.remove(0));
            this.notifyAll();
        }
    }

    static class Producer extends Thread{
        private MyStack myStack;

        public Producer(MyStack myStack){
            this.myStack = myStack;
        }

        @Override
        public void run() {
            while (true){
                myStack.add();
            }
        }
    }

    static class Consumer extends Thread{
        private MyStack myStack;

        public Consumer(MyStack myStack){
            this.myStack = myStack;
        }

        @Override
        public void run() {
            while (true){
                myStack.pop();
            }
        }
    }
}
