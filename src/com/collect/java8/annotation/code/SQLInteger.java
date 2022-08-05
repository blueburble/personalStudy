package com.collect.java8.annotation.code;

public @interface SQLInteger {
    String name() default "";
    Constraints cons() default  @Constraints;
}
