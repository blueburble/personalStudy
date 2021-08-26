package com.jinkui.structure;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args){
            int[] array = new int[]{8,1,4,2,6,9,10};
            selectSort2(array);
            System.out.println(Arrays.toString(array));

    }

    /***
     * 选择排序
     * 时间复杂度n²
     * 空间复杂度O(1)
     * 最好 最坏 n2
     * 平均n2
     * 非稳定排序
     *
     *
     *
     *
     * @param list
     */

    static void selectSort(int[] list){
        if(null == list || list.length <= 1){
            return;
        }
        for(int i = 0; i < list.length; i++){
            int min = i;
            for(int j = i + 1; j < list.length; j ++){
                if(list[j] <  list[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }
    }


    static void selectSort2(int[] list){
        if(null == list || list.length <= 1){
            return;
        }

        for(int i = 0; i < list.length - 1; i ++){
            int min = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j] <  list[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }
        }

    }
}
