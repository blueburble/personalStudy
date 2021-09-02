package com.jinkui.structure;

import java.util.Arrays;

/**
 * 归并排序
 *
 *
 */
public class MergeSort {


    public static void main(String[] args){
        int[] array = new int[]{1,6,9,10,2,4};
        sort(array, 0,  array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    /**
     *
     *
     * 递推公式： merge_sort(p...r) =  merge( merge_sort(p...q),  merge_sort(q + 1, ...r) )
     *
     *
     *
     * @param array
     */
    static void sort(int[] array, int p, int r){

        if(p >=  r){
            return ;
        }

       int q = (p + r)/2;


        sort(array, p ,q);
        sort(array, q + 1, r);

        merge(array, p, q, r);
    }

    static void merge(int[] array, int first,  int mid, int last){
            int i = first;
            int j = mid + 1;
            int k = 0;
            int[] temp = new int[last - first + 1];
            while (i <= mid && j <= last){
                //比较
                if(array[i] <= array[j]){
                    temp[k++] = array[i++];
                }else {
                    temp[k++] = array[j++];
                }
            }

            while (i <= mid){
                temp[k++] = array[i++];
            }

            while (j <= last){
                temp[k++] = array[j++];
            }

            //回拷
            for(int l = 0; l < k; l ++){
                array[first + l] = temp[l];
            }

            System.out.println("--------" + Arrays.toString(array) +  first + mid + last);
    }



}

