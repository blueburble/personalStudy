package com.collect.dataStructure.code;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args){
        int[] array = {5,7,10,90,1,99999,5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){ // 0 1 2 3 4 5 6
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){ // 1 2  3 4 5 6 7
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
    }



}
