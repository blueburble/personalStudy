package com.jinkui.structure.zuoshen;

import java.util.Arrays;
import java.util.List;

public class InsertSort {

    public static void main(String[] args) {
        int[] list = {5,9,19,2,1,5,1,5,9};

        sort3(list);

        System.out.println(Arrays.toString(list));
    }


    public static void sort(int[] list){

        if(list == null || list.length < 2){
            return;
        }

        for(int i = 1; i < list.length; i ++){
            for(int j = i  - 1; j >= 0 && list[j] > list[j + 1]; j--){
                swap(list, j , j+1);
            }
        }

    }

    public static void sort2(int[] list){
        if(null == list || list.length < 2){
            return;
        }
        for(int i = 1; i < list.length; i ++){

            for(int j = i - 1; j >= 0 && list[j] > list[j + 1]; j--){
                swap(list, j, j+1);
            }

        }
    }

    public static void sort3(int[] list){
        if(null == list || list.length <2){
            return;
        }
        for(int i = 1; i < list.length; i ++){
            for(int j = i - 1; j >= 0 && list[j] > list[j + 1]; j--){
                swap(list, j, j + 1);
            }
        }
    }

    public static void swap(int[] list, int i, int j){
        list[i] = list[i] ^ list[j];
        list[j] = list[i] ^ list[j];
        list[i] = list[i] ^ list[j];
    }



}
