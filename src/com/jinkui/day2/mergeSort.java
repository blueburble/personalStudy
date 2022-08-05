package com.jinkui.day2;

import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args){

        int[] arr = new int[]{7,10,8,6,3,2,1,10,9};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int left , int right){

        if(left == right){
            return;
        }

        int mid = left + ((right - left) >> 1);

        mergeSort(arr, 0, mid);

        mergeSort(arr, mid +1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right){
       int p1 = left;
       int p2 = mid +1;
       int tempArr[] = new int[right - left + 1];
       int index = left;
       while(p1 <= mid && p2 <= right){
           tempArr[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
       }
       while(p1 <= mid){
           tempArr[index++] = arr[p1++];
       }
       while(p2 <= right){
           tempArr[index++] = arr[p2++];
       }
        index = left;
       while (index <= right){
           arr[index] = tempArr[index++];
       }
    }


}
