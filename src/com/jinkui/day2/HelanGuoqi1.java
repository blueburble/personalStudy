package com.jinkui.day2;

import java.util.Arrays;

public class HelanGuoqi1 {

    /**
     * <= .. >
     * @param args
     */
    public static void main(String[] args){
        int[] arr = {4,1,6,19,80,1,3,4,5};
        helanguoqiSort1(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    static int[] helanguoqiSort1(int[] arr, int sortNum){
        int left = -1;
        int index = 0;
        while(index < arr.length){
            if(arr[index] <= sortNum){
                swap1(arr, ++left, index++);
            }else{
                index++;
            }
        }
        return arr;
    }

    static int[] helanguoqiSort2(int[] arr, int sortNum){
        int p1 = -1;
        int p2 = arr.length;
        int index = 0;
        while(index < p2){
            if(arr[index] < sortNum){
                //如果小于 与 < 区间的数做交换
                swap(arr, ++p1, index++);
            }else if(arr[index] > sortNum){
                //如果大于 与 > 区间的数做交换 交换过来的数重新判断
                swap(arr,  --p2, index);
            }else{
                //等于的话数据不动 index++
                index++;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    static void swap1(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
