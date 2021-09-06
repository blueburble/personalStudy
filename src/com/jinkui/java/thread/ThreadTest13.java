package com.jinkui.java.thread;

public class ThreadTest13 {
    public static void main(String[] args){

        BaijuClass bj = new BaijuClass();
        new My22Thread(bj).start();
        try {
            Thread.sleep(100);
            bj.printlnBaijuClass();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class BaijuClass{
        private String name = "张三";
        private String passWord = "kedacom123";

        //避免发生脏读现象
        public synchronized void printlnBaijuClass(){
            System.out.println("this Obj getter" + this.name + this.passWord);
        }

        //避免发生脏读现象
        public synchronized void changeBaijuClass(String name, String pwd){
            this.name  = name;
            try {
                Thread.sleep(4000);
                passWord = pwd;
                System.out.println("this Obj setter" + this.name + this.passWord);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class My22Thread extends  Thread{

    private ThreadTest13.BaijuClass baijuClass;

    public My22Thread(ThreadTest13.BaijuClass baiji){
        this.baijuClass = baiji;
    }

    @Override
    public void run() {
        this.baijuClass.changeBaijuClass("李四", "jinggui124");
    }
}
