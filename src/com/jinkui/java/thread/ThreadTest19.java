package com.jinkui.java.thread;

//CAS实现 线程安全计数器

public class ThreadTest19 {

    public static void main(String[] args){
            AtomaticCount at = new AtomaticCount();
            for(int i = 0; i< 10000; i++){
                new Thread(() -> System.out.println(at.addAndReturn())).start();
            }

    }


}

class AtomaticCount{
    volatile private long value;


    public long getValue(){
        return value;
    }

    private boolean compareAndSwap(long expectedValue, long newValue){
        synchronized (this){
            if(expectedValue == value){
                value = newValue;
                return true;
            }else {
                return false;
            }
        }
    }

    public long addAndReturn(){
        long oldCount;
        long newCount;

        do{
            oldCount = getValue();
            newCount = oldCount  + 1;
        }while (!compareAndSwap(oldCount, newCount));

        return newCount;
    }
}
