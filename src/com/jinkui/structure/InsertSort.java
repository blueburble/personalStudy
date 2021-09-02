package com.jinkui.structure;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args){
        int[] array = new int[]{4,6,1,3,3,2,1,9,80};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 插入排序
     * 1. 时间复杂度: n²
     * 2. 稳定、原地排序算法
     * 3.空间复杂度 O(1)
     * 4.平均时间复杂度n²
     * 最好 n   最坏 n²
     *
     *
     *
     *
     *
     *
     * @param list
     */
    static void insertSort(int[] list){
        if(null == list || list.length <= 1){
            return;
        }
        //默认第一个插入
        for(int i = 1; i < list.length; i++){
            int value = list[i];
            int j = i - 1;
            for(; j >=0; j--){
                if(list[j] > value){
                    list[j + 1] = list[j];
                }else {
                    break;
                }
            }
            list[j + 1] = value;
        }
    }


    static void insertSort2(int[] list){
        if(null == list || list.length < 2){
            return;
        }
        for(int i = 1; i< list.length; i ++){
            int value = list[i];
            int j = i - 1;
            //找到插入的位置
            for(; j >= 0; j --){
                if(list[j] > value){
                    list[j + 1] = list[j];
                }   else {
                    break;
                }
            }
            list[j + 1] = value;
        }
    }


}
