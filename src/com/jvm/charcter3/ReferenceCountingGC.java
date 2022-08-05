package com.jvm.charcter3;

import com.collect.java8.annotation.code.Test;

public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1mb = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1mb];


    public static void main(String[] args) {
        testGc();
    }
    public static void testGc(){
        ReferenceCountingGC gc1 = new ReferenceCountingGC();
        ReferenceCountingGC gc2 = new ReferenceCountingGC();
        gc1.instance = gc2;
        gc2.instance = gc1;

        gc1 = null;
        gc2 = null;

        System.gc();
    }
}
