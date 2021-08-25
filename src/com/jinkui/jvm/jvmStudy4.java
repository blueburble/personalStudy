package com.jinkui.jvm;

public class jvmStudy4 {
        public static void main(String[] args) throws InterruptedException {
            int i = 0;
            Thread.sleep(10000);
            System.out.println("bye");
            System.exit(0);
        }
}


/**
 * jvm 生命周期
 *
 * 启动：通过引导加载类创建一个初始类来完成的 这个类是由虚拟机的具体实现指定的
 *
 *
 *
 *执行： 一个运行的java虚拟机有着清晰的任务,运行java程序,程序开始执行它运行,程序结束时他就停止；执行一个所谓的java程序的时候,真真正正的执行的是一个叫java虚拟机的进程
 *
 *
 * 命令  jps   查看当前进程
 *
 *
 * 退出:
 * 1) 程序正常结束
 * 2) 程序在执行的过程中遇到了异常或错误而异常终止
 * 3) 由于操作系统出现错误导致java进程终止
 * 4)某线程调用Runtime类或System类的exit 方法 或Runtime 的 halt 方法 并且java安全管理器也允许此次操作
 *JNI 规范了用JNI 来加载或者卸载java 虚拟机的 退出情况
 *
 */
