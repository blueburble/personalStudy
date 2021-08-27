package com.jinkui.jvm;

public class jvmStudy6 {
    public static void main(String[] args) {
       ClassLoader classLoader = jvmStudy6.class.getClassLoader();
       System.out.println(classLoader);

       System.out.println(Thread.currentThread().getContextClassLoader());

       System.out.println(ClassLoader.getSystemClassLoader().getParent());
    }
}
