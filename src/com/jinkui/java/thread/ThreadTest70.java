package com.jinkui.java.thread;

public class ThreadTest70 {
    /**
     * 守护线程是为其他服务提供的， 当jvm中只有守护线程的时候 守护线程销毁 jvm 退出
     * @param args
     */
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group");

        //设置线程组为守护线程组
        group.setDaemon(true);

        for(int i = 0; i < 10; i++){
            new Thread(group, ()->{
                for(int j = 0; j< 20; j++){
                    System.out.println(Thread.currentThread().getName() +"---" + j);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
