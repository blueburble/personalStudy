package com.jinkui.day1;

import java.util.Arrays;

public class selectSort {

    public static void main(String[] args){

        int[] arr = {3,10,0,1,2,2,1};

        selectSort(arr);

         System.out.println(Arrays.toString(arr));
    }


    private static void selectSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }

        for(int i = 0; i < arr.length - 1; i++){

            int minIndex = i;

            for(int j = i + 1; j < arr.length; j ++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            if(minIndex != i)   swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
