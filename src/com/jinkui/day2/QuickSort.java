package com.jinkui.day2;

import java.util.Arrays;

public class QuickSort {;

    public static void main(String[] args){
        int[]  arr = {4,2,1,8,9,10,70,30};
        quickSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

   static void quickSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort1(arr, 0, arr.length - 1);
   }

    static void quickSort1(int[] arr, int left, int right){
        if(left < right){
            int[] p = partition(arr, left, right);
            quickSort1(arr, 0, p[0] - 1);
            quickSort1(arr, p[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int L , int R){
        int less = L - 1;
        int more = R;
        int index = 0;
        while(index < more){
            if(arr[index] < arr[R]){
                swap(arr, ++less, index++);
            }else if(arr[index] > arr[R]){
                swap(arr,  --more,  index);
            }else{
                index++;
            }
        }
        swap(arr, more, R);
        return new int[]{less +1, more};
    }

    /**
     * 上游确定内存地址不相等
     * @param arr
     * @param i
     * @param j
     */
    static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
