package com.jvm.charcter2;

import java.util.ArrayList;
import java.util.List;

public class JVMTest1 {

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }


    static class OOMObject{
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<JHSDB_TestCase.OOMObject> OOMs = new ArrayList<>();
        for(int i = 0; i < num; i ++){
            Thread.sleep(50);
            OOMs.add(new JHSDB_TestCase.OOMObject());
        }
        System.gc();
    }
}
