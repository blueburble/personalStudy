package com.jinkui.java.thread;

public class ThreadTest16 {

    public static void main(String[] args) throws InterruptedException {

           /* //main线程修改标志未成功停止程序
            PrintString printString = new PrintString();
            printString.printMethod();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printString.changeFlag(false);*/


            PrintString printString = new PrintString();

            new Thread(() -> printString.printMethod()).start();

            Thread.sleep(5000);

            System.out.println(Thread.currentThread().getName() + "修改标志位");
            printString.changeFlag(false);


    }

    static class PrintString{
        //强制线程从公共内存当中读取变量的值

        private volatile Boolean flag = true;

        public PrintString changeFlag(boolean flag){
            this.flag = flag;
            return this;

        }

        public void printMethod(){
            System.out.println(Thread.currentThread().getName() + "开始");
            while(flag){
                /*System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
}
