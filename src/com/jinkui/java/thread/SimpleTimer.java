package com.jinkui.java.thread;

public class SimpleTimer {

    private static int time = 60;

    public static void main(String[] args){
        time = args.length >  0 ? Integer.parseInt(args[0]) : 60;
        while (true){
            if(time < 0){
               break;
            }
            System.out.println("Ramain: " + time--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("计时结束");
    }
}
