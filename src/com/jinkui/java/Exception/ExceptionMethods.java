package com.jinkui.java.Exception;

public class ExceptionMethods {
    public static void main(String[] args){
        try{
            throw new Exception("mY EXCEPTION");
        }catch (Exception e){
            System.out.println("caught Exception");
            System.out.println("get message():" + e.getMessage());
            System.out.println("get LocalMessage(): " + e.getLocalizedMessage());
            System.out.println("toString" + e);
            System.out.println("printStackTrace()");
            e.printStackTrace();
        }
    }
}
