package com.jinkui.jvm;

public class jvmStudy5 {
}

/**
 * 第一款虚拟机    Sun classic    只有解释器  (逐行翻译)  无JIT 效率较低     不能共用
 *
 *热点代码 -》 本地机器指令-》 缓存
 *不能全部使用JIT  全部使用 时 暂停时间过长
 *
 *Exact VM    编译器和解释器可以共用      短
 *
 *
 * hotspot   绝对市场地位   特点 方法区的概念     商用之一
 *
 *
 * Jrocket 最快的jvm 不包含解析器实现  全部都靠即时编译器编译后执行 商用之一
 *
 *
 * IBM J9  号称最快  OpenJ9  商用之一
 *
 *
 *
 *KVM   低端设备市场    后者的前身
 * CDC/CLDC  移动断
 *
 *
 *
 * 所有虚拟机的原则   :    一次编辑 到处运行
 *
 *
 *
 *
 * Azul VM 与特定硬件绑定、软硬件配合的专有虚拟机
 *
 * Liquid VM   本身实现了专用的操作系统的功能        随着Jrocket   暂停了
 *
 * Apache Harmony    获取不了jcp认证    转向android
 *
 * MicroSoft vm
 *
 *TaoBao JVM   性能好 依赖interCPU
 *
 *
 *
 *
 * Dalvik VM   寄存器架构   执行效率快  硬件耦合度高
 *
 *
 *
 *Graal Jvm  跨语言全栈虚拟机
 *
 */