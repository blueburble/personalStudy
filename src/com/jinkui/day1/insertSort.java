package com.jinkui.day1;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args){
        int arr[] = {2,1,0,2,1,19,100};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0  && arr[j] > arr[j + 1]; j --){
                swap(arr, j+1 , j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
