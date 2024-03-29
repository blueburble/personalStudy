package com.collect.java8.typeInfo.code;

import java.util.HashMap;
import java.util.stream.Collectors;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }
    public void count(Object obj){
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException("");
        }
        countClass(type);
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type, quantity == null ?  1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        String result = entrySet().stream().map(pair -> String.format("%s= %s", pair.getKey().getSimpleName(), pair.getValue()) ).collect(Collectors.joining(", "));
        return "{"  + result + "}";
    }
}
