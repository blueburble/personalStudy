package com.jvm.charcter2;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class JHSDB_TestCase {

    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }




    public static class ObjectHolder {

    }

    public static void main(String[] args) throws InterruptedException {
    /*    Test test = new Test();
        test.foo();*/
        fillHeap(1000);
    }


    static class OOMObject{
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> OOMs = new ArrayList<>();
        for(int i = 0; i < num; i ++){
            Thread.sleep(50000000);
             OOMs.add(new OOMObject());
        }
        System.gc();
    }
}
