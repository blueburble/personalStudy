package com.jinkui.java.thread;

import java.util.Arrays;

/**
 *
 *      选择排序
 *
 *
 */
public class ThreadTest83 {

    public static void main(String[] args) {

        int[] list = new int[]{4,4,3,1,5,9,2,8,4,7,1,10,4};

        selectSort(list);

        System.out.println(Arrays.toString(list));

    }

    public static void selectSort(int[] list){

        for(int i = 0; i < list.length - 1; i ++){

            int min = i;

            for(int j = i + 1; j < list.length; j ++){

                if(list[min] > list[j]){
                        swap(list, min, j);
                }

            }

        }

    }

    public static void swap(int[] list, int i, int j){
        list[i] = list[i] ^ list[j] ;
        list[j] = list[i]  ^ list[j];    ///list[i}
        list[i] = list[i]  ^ list[j];

    }



}
