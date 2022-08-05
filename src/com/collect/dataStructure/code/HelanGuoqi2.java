package com.collect.dataStructure.code;

import java.util.Arrays;

public class HelanGuoqi2 {

    /**)1,9,9,10,888888,1,3,2,90,80,10,80(
     * 1) 9 9 10 888888  1 3 2 90 80 10 80(
     * 1 9 ) 9 10 888888 1 3 2 90 80 10 80(
     * 1 9 9 10) 888888 1 3 2 90 80 10 80(
     * 1 9 9 10) 80 1 3 2 90 80 10 80 (888888
     *1 9 9 10 1)80 3 2 90 80 10 80 (888888
     *1 9 9 10 1 3) 80 2 90 80 10 80 (888888
     *1 9 9 10 1 3 2 )80 90 80 10 80 (888888
     * 1 9 9 10 1 3 2 )80 80 80 10 (90 888888
     * 1 9 9 10 1 3 2 10) 80 80 80 (90 888888
     * @param args
     */
    public static void main(String[] args){
        int[] arr = {1,9,9,10,888888,1,3,2,90,80,10,80};
        helanguoqi2(arr,80);
        System.out.println(Arrays.toString(arr));
    }

    public static void helanguoqi2(int[] arr, int num){
        if(arr == null || arr.length < 2){
            return;
        }
        int less = -1;
        int more = arr.length ;
        int left = 0;
        while (left < more){
            if(arr[left] == num){
                left++;
            }else if(arr[left] < num){
                swap(arr, ++less, left++);
            }else {
                swap(arr, --more, left);
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]  = temp;
    }
}
