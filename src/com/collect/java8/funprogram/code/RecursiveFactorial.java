package com.collect.java8.funprogram.code;

public class RecursiveFactorial {
    static IntCall intCall;
    public static void main(String[] args){
        //分析递归流程
        /**
         * 5
         * 5 * x1 ？ x1= intCall.call(4)                                             返回5*24  =  120
         *       x1 = 4 * x2 ?  x2 = intCall.call(3)                        返回24
         *          x2 = 3 * x3 ? x3 = intCall.call(2)                 返回6
         *             x3 = 2* x4 ? x4 = intCall.call(1)                   返回 2
         *                 x4 = 1 * x5 ? x5  = intCall.call(0)          ·   1
         *                    X5 =  1
         */
        intCall = n -> n  == 0 ? 1 :   n * intCall.call(n - 1);
        for(int i = 0; i < 10; i++){
            System.out.println(intCall.call(i));
        }
    }
}


interface IntCall{
    int call(int arg);
}