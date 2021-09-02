package com.jinkui.java;

public class LambdaTest3 {
    static IntCall intCall;
    public static void main(String[] args){
        intCall = n -> n == 0 ? 1 :  n * intCall.call(n - 1);
        for(int i = 0; i< 10; i ++){
            System.out.println(intCall.call(i));
        }
    }

}
interface IntCall{
    int call(int arg);
}
