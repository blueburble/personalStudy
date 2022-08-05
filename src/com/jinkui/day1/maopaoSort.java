package com.jinkui.day1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class maopaoSort {

    public static void main(String[] args){

        int[] arr = {5,1,3,10,2,9,10,2};

        maopaoSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void maopaoSort(int[] arr){

        if(null == arr  || arr.length < 2){
            return;
        }

        for(int i = arr.length - 1; i > 0; i --) {

            for(int j = 0; j < i; j++){

                if(arr[j + 1] < arr[j]){
                    swap(arr, j, j + 1);
                }

            }

        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
