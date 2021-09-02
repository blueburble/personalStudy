package com.jinkui.java.lambda;

public class RecursiveFactorial {
    static IntCall intCall;
    public static void main(String[] args){
        intCall = n  -> n == 0 ? 1 :  n * intCall.call(--n);
        for(int i = 0; i< 10; i++){
            System.out.println(intCall.call(i));
        }
    }
}


interface IntCall{
    int call(int arg);
}