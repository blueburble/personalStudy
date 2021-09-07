package com.jinkui.java.thread;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * 管道流线程之间数据传输
 */
public class ThreadTest38 {
    public static void main(String[] args) {

        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() ->writeData(outputStream)).start();
        new Thread(() ->readData((inputStream))).start();
    }

    //定义方法向管道流中写入数据
    public static void writeData(PipedOutputStream pipedOutputStream){
        try {
            for (int i = 0; i < 100; i++) {
                pipedOutputStream.write(("" + i).getBytes());
            }
            pipedOutputStream.close();
        }  catch (IOException e) {
            e.printStackTrace();
    }
    }

    public static void readData(PipedInputStream inputStream){
        byte[] bytes = new byte[1024];
        try {
            int length =  inputStream.read(bytes);
            while (length  != -1){
                    System.out.println(new String(bytes, 0, length));
                    length = inputStream.read(bytes);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
