package com.collect.dataStructure.code;

import java.util.Arrays;

public class ErfenFindNum {

    public static void main(String[] args){
        int arr[] = {9,20,10,5,6,19,40, 90};
        InsertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ErfenFind(arr, 0, arr.length - 1, 10));

    }

    public static int ErfenFind(int[] arr, int L, int R, int num){
        if(L > R){
            return -1;
        }
         int middle = L + (R - L) >> 1;

         if(arr[middle] < num){
             return ErfenFind(arr, middle + 1, R, num);
         }
         if(arr[middle] > num){
             return ErfenFind(arr, L, middle - 1 , num);
         }

        return middle;
    }
}
