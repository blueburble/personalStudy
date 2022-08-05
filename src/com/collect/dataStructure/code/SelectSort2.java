package com.collect.dataStructure.code;

import java.util.Arrays;

public class SelectSort2{


    public static void main(String[] args){

        int arr[] = {1,5,20,6,7,2,0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    private static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }



}

