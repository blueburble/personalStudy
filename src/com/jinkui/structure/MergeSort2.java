package com.jinkui.structure;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args){
        int[] array = new int[]{3,1,5,9,10,31,2};
        sort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    static void sort(int[] array, int p, int r){
        //递归终止条件
        if(p >= r){
            return;
        }
        //计算分割点
        int mid = (p  + r)/ 2;
        //递归
        sort(array, p, mid);
        sort(array, mid + 1, r);
        merge(array, p , mid, r);
    }

    static void merge(int[] array, int start, int mid, int end){

        int i = start;
        int j = 0;
        int k = mid + 1;
        int temp[] = new int[end - start + 1];
        while(i <= mid && k <= end){
            if(array[i] < array[k]){
                temp[j++] = array[i++];
            }else{
                temp[j++] = array[k++];
            }
        }
        while(i <= mid){
            temp[j++] = array[i++];
        }
        while(k <= end){
            temp[j++] = array[k++];
        }
        for(int p = 0; p < temp.length; p ++){
            array[start + p] = temp[p];
        }
    }
}
