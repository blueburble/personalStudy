package com.jinkui.structure;

import java.util.Arrays;

/**
 * 归并排序
 *
 *
 */
public class MergeSort {


    public static void main(String[] args){

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
    static int[] sort(int[] array){
        if (null == array || array.length <= 1){
            return array;
        }

        if(array.length <= 1){
            return array;
        }
        int middle  = (int) Math.floor(array.length/2);

        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle + 1, array.length);

        return merge(sort(left), sort(right));
    }

    static int[] merge(int[] left, int[] right){
        int[] array = new int[left.length + right.length];
        int i = 0;
        while(left.length > 0 && right.length > 0){
            if (left[0] < right[0]) {
                array[i ++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else {
                array[i ++] = right[0];
                left = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0){
          /*  array[]*/
        }
        return null;
    }
}

