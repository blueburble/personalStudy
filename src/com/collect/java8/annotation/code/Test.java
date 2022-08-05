package com.collect.java8.annotation.code;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义用在哪里、是方法还是字段
@Target(ElementType.METHOD)
//可以在哪里用 源代码、CLASS文件 或者 runTime
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    int id();
    String description () default "no description";
    //
}
