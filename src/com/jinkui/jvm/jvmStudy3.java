package com.jinkui.jvm;

/**
 * @a
 */
public class jvmStudy3 {

    public static void main(String[] args){
        // int i  = 2 + 3;
        int i = 2;
        int j = 3;
        int k =i + j;
    }
}


/**
 *
 *  java代码执行流程
 *
 *
 *  java源码 -》java字节码   前端编译
 *
 *
 *java虚拟机中 翻译字节码  将字节码转为机器语言  JIT 编译器控制性能 缓存热方法
 *
 *
 *
 * jvm 架构模型
 *
 * 1.基于栈的指令集架构(hotSpot)  跨平台性、指令集小、指令多       执行性能比寄存器差
 *
 * 2.基于寄存器的指令集架构    可移植性差、
 *
 *指令的执行 （地址，操作数）
 *
 *
 *
 *
 */