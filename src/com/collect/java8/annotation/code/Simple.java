package com.collect.java8.annotation.code;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,ElementType.PACKAGE, ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.PARAMETER})
public @interface Simple {
    String value() default  "default";
}
