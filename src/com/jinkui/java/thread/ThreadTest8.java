package com.jinkui.java.thread;

public class ThreadTest8 {

    public static void main(String[] args){
        My5Thread threadA = new My5Thread();
        threadA.setName("xiaohong");
        threadA.setPriority(10);
        threadA.start();
        My5Thread threadB = new My5Thread();
        threadB.setName("XIAOGANG");
        threadB.setPriority(1);
        threadB.start();
    }


}


/**
 *
 * 綫程優先級測試
 */

class My5Thread extends Thread{
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for(int i = 0; i < 99999999; i++){
            sum += i;
        }
        System.out.println( this.getName() + ":" + (System.currentTimeMillis() - startTime));
    }
}