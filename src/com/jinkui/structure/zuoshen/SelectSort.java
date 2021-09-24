package com.jinkui.structure.zuoshen;

import java.util.Arrays;

/**
 * 选择排序          先以第一个为最小的 、    从后面的剩下元素中找到最小的
 *
 * 时间复杂度    n²
 */
public class SelectSort {

    public static void main(String[] args){

        int[] list = {5,9,19,2,1,5,1,5,9};

        sort4(list);

        System.out.println(Arrays.toString(list));

    }

    public static void sort(int[] list){

        //判断
        if(null == list || list.length < 2){
            return;
        }

        for(int i = 0; i < list.length - 1; i ++){
            int minIndex = i;

            //找到最小的
            for(int j = i + 1; j < list.length; j ++){
                minIndex = list[minIndex] > list[j] ? j : minIndex;
            }

            //交换
            if(minIndex != i){
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }

        }

    }


    public static void sort2(int[] list){
        if(list == null || list.length < 2){
            return;
        }

        for(int i = 0; i < list.length; i++){
            int minIndex  = i;
            for(int j = i +1;  j < list.length; j++){
                minIndex = list[minIndex] > list[j] ? j : minIndex;
            }

            if(minIndex != i){
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }

    public static void sort3(int[] list){

        if(null == list || list.length < 2){
            return;
        }

        for(int i = 0; i < list.length; i++){

            int minIndex = i;

            for(int j = i + 1; j < list.length; j++){
                minIndex = list[minIndex] > list[j] ? j : minIndex;
            }

            if(minIndex != i){
                list[i] = list[i] ^ list[minIndex];
                list[minIndex] = list[i] ^ list[minIndex];
                list[i] = list[i] ^ list[minIndex];

            }


        }
    }


    public static void sort4(int[] list){
        if(list == null || list.length < 2){
            return;
        }
        for(int i = 0; i < list.length; i ++){
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++){
                minIndex = list[j] < list[minIndex] ? j : minIndex;
            }
            if(minIndex != i){
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }
}
