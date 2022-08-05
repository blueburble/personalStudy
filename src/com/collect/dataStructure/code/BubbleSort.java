package com.collect.dataStructure.code;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {5,999,0,2,6,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int j = arr.length - 1; j >0; j --){
            for(int i = 0; i < j; i++){
                if(arr[i + 1] < arr[i]){
                    swap(arr, i + 1, i);
                }
            }
        }

    }

    public static void swap(int[] arr, int i , int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
