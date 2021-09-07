package com.jinkui.java.thread;

public class ThreadTest36 {
    public static void main(String[] args){
        ValueOp valueOp = new ValueOp();
        ConsumerThread consumerThread = new ConsumerThread(valueOp);
        ProducerThread producerThread = new ProducerThread(valueOp);
        ConsumerThread consumerThread2 = new ConsumerThread(valueOp);
        ProducerThread producerThread2 = new ProducerThread(valueOp);
        ConsumerThread consumerThread3= new ConsumerThread(valueOp);
        ProducerThread producerThread3 = new ProducerThread(valueOp);
        consumerThread.start();
        producerThread.start();
        consumerThread2.start();
        producerThread2.start();
        consumerThread3.start();
        producerThread3.start();
    }




    /**
     * 定义一个操作数据的类
     */

    static class ValueOp{
        private String value = "";

        public void setValue(){
            synchronized (this){
                while(!"".equalsIgnoreCase(value)){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String  value = System.currentTimeMillis() + "_" +   System.nanoTime();
                System.out.println("设置的值是" + value);
                this.value = value;
                this.notifyAll();
            }
        }

        public void getValue(){
            synchronized (this){
                while("".equalsIgnoreCase(value)){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("get的值" + value);
                this.value = "";
                //在多生产多消费中 notify不能保证是消费者唤醒生产者、、 可能会出现假死的情况
                this.notifyAll();
            }
        }
    }


    /**
     * 生成
     */

    static class ProducerThread extends Thread{
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

    static class ConsumerThread extends Thread{
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
}
