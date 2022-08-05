package com.collect.java8.annotation.code;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PassWordUtils {

    @UseCase(id = 47, description = "passWord must contains")
    public Boolean validatePassWord(String passWd){
        return false;
    }

    @UseCase(id = 48)
    public String encryptPassWord(String passWd){
        return new StringBuilder(passWd).reverse().toString();
    }

    @UseCase(id = 49, description="NEW PASS WORD CANNOT SAME AS OLD PASSWORD")
    public Boolean checkForNewPassWord(List<String> passWds, String passWd){
        return !passWds.contains(passWd);
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl){
        for(Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case" + uc.id() + "\n" + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        useCases.forEach(i -> System.out.println("missing use case" + i));
    }

    public static void main(String[] args){
        List<Integer> useCases = IntStream.range(47, 51).boxed().collect(Collectors.toList());
        trackUseCases(useCases, PassWordUtils.class);
    }
}
