package com.collect.dataStructure.code;

public class Weiyunsuan1 {
    public static void main(String[] args){
        int[] arr = {8,10,10,1,1,50,50};
        getOneNumber(arr);
        int[] arr_2 = {8,10,10,1,1,50,50,9};
        getTwoNumber(arr_2);
    }

    public static void  getOneNumber(int[] arr){
        int temp = 0;
        for(int _arr : arr){
            temp ^= _arr;
        }
        System.out.println(temp);
    }



    public static void getTwoNumber(int[] arr){
        int temp = 0;
        for(int _arr : arr){
            temp ^= _arr;
        }
        int _temp = 0;
        // 取反 + 1 取得 最右边的 1
        int temp2 = temp & ( ~temp + 1);
        for(int _arr : arr){
            if((temp2 & _arr) == 0){
                _temp ^= _arr;
            }
        }
        int oneNumber = temp ^_temp;   // 加入是a
        int otherNumber = oneNumber ^ temp; // a ^ a ^ b = b
        System.out.print("a number is" + oneNumber + "other is" + otherNumber);
    }
}
