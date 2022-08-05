package com.collect.java8.typeInfo.code;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage:" +
             "ShowMethods qualified.class.name" +
             "To show all methods in class or:" +
            "ShowMethods qualified.class.name word" +
             "To search for methods involving 'word'";

    private static Pattern pattern = Pattern.compile("\\w+\\.");

    public static void main(String[] args){
        if(args.length < 1){
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try{
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if(args.length == 1){
                for(Method method : methods){
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                }
                for(Constructor constructor: ctors){
                    System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length +ctors.length;
            }else {
                for(Method method : methods){
                    if(method.toString().contains(args[1])){
                        System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for(Constructor constructor: ctors){
                    if(constructor.toString().contains(args[1])){
                        System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                        lines++;
                    }

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
