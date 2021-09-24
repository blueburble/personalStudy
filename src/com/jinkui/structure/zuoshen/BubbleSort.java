package com.jinkui.structure.zuoshen;

import java.util.Arrays;


/**
 * 冒泡排序  每次两两个元素比较 前面的大 就 移动   每次可以得到 最右边的最大
 *
 * 时间复杂度 n²
 *
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] list = {5,9,19,2,1,5,1,5,9};
        sort3(list);
        System.out.println(Arrays.toString(list));
    }

    public static void sort(int[] list){

        //判断
        if(null == list || list.length < 2){
            return;
        }

        for(int i = list.length - 1; i > 0 ;i --){
            for(int j = 0; j < i; j ++){
                if(list[j] > list[j +1]){
                   swap(list, j, j+1);
                }
            }
        }

    }

    public static void sort2(int[] list){
        if(null == list || list.length < 2){
            return;
        }

        for(int i = list.length - 1; i >=0; i--){
            for(int j = 0; j < i; j++){
                if(list[j] > list[j+1]){
                    swap(list, j , j+1);
                }
            }
        }

    }

    public static void sort3(int[] list){
        if(null == list || list.length < 2){
            return;
        }
        for(int i = list.length - 1;  i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(list[j] > list[j + 1]){
                    swap(list, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] list, int i, int j){
        list[i] = list[i] ^ list[j];
        list[j] = list[i] ^ list[j];
        list[i] = list[i] ^ list[j];

    }


}
