package com.jinkui.structure.MyTest;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {3,1,9,32,1,0,90,36};

        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = arr.length - 1 ;  i >=0; i --){
            for(int j = 0; j < i; j ++){
                if(arr[j] > arr[j +1]){
                    arr[j] = arr[j] ^ arr[j +1];
                    arr[j + 1] = arr[j] ^ arr[j +1];
                    arr[j] = arr[j] ^ arr[j +1];
                }
            }
        }
    }
}
