package com.jinkui.java.thread;

import java.util.concurrent.atomic.AtomicLong;

public class Indicator {

    //构造方法私有化
    private Indicator(){

    }

    private static final Indicator in = new Indicator();

    public static Indicator getInstance(){
        return in;
    }

    private final AtomicLong requestCount = new AtomicLong(0);
    private final AtomicLong successCount = new AtomicLong(0);
    private final AtomicLong failureCount = new AtomicLong(0);

    public void newRequestReceive(){
        requestCount.incrementAndGet();
    }

    public void newSuccessCount(){
        successCount.incrementAndGet();
    }

    public void newErrorCount(){
        failureCount.incrementAndGet();
    }

    public long viewAllCount(){
        return requestCount.get();
    }

    public long viewSuccessCount(){
        return successCount.get();
    }

    public long viewErrorCount(){
        return failureCount.get();
    }

}
