package com.jinkui.java.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest40 {


    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    static class ParseDate implements Runnable{

        private int i = 0;

        public ParseDate(int i){
            this.i = i;
        }
        @Override
        public void run() {
                String text = "2068年11月22日 08:28:" + i%60;
                try {
                    /*Date date = simpleDateFormat.parse(text);*/
                    if(null == threadLocal.get()){
                        threadLocal.set(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
                    }
                    Date  date = threadLocal.get().parse(text);
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

        }

    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            new Thread(new ParseDate(i)).start();
        }
    }
}
