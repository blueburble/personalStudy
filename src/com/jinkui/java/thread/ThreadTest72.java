package com.jinkui.java.thread;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ThreadTest72 {

    /**
     * Jvm退出时会执行Hook线程     程序启动创建.lock文件 程序退出删除该.lock文件 防止程序重复启动
     * @param args
     */
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("JAVA虚拟机退出会启动当前hook线程, 删除.lock文件");
            getLockFile().toFile().delete();
        }));

        if(getLockFile().toFile().exists()){
            throw new RuntimeException("程序已启动");
        }else{
            try {
                getLockFile().toFile().createNewFile();
                System.out.println("程序启动-- 创建Lock文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        for(int i = 0; i <10; i++){
            System.out.println("程序正在运行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static Path getLockFile(){
        return Paths.get("", "tmp.lock");
    }

}
