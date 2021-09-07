package com.jinkui.java.thread;

public class ThreadTest35 {
    public static void main(String[] args){
        ValueOp valueOp = new ValueOp();
        ConsumerThread consumerThread = new ConsumerThread(valueOp);
        ProducerThread producerThread = new ProducerThread(valueOp);
        consumerThread.start();
        producerThread.start();
    }
}


/**
 * 定义一个操作数据的类
 */

class ValueOp{
    private String value = "";

    public void setValue(){
        synchronized (this){
            if(!"".equalsIgnoreCase(value)){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String  value = System.currentTimeMillis() + "_" +   System.nanoTime();
            System.out.println("设置的值是" + value);
            this.value = value;
            this.notify();
        }
    }

    public void getValue(){
        synchronized (this){
            if("".equalsIgnoreCase(value)){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("get的值" + value);
            this.value = "";
            this.notify();
        }
    }
}


/**
 * 生成
 */

class ProducerThread extends Thread{
    private ValueOp valueOp;

    public ProducerThread(ValueOp valueOp){
        this.valueOp = valueOp;
    }

    @Override
    public void run() {
        while(true){
            valueOp.setValue();
        }

    }
}

/**
 * 消费
 */

class ConsumerThread extends Thread{
    private ValueOp valueOp;

    public ConsumerThread(ValueOp valueOp){
        this.valueOp = valueOp;
    }

    @Override
    public void run() {
        while(true) {
            valueOp.getValue();
        }
    }
}