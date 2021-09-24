package com.jinkui.structure.MyTest;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args){
        int[] arr = {3,1,9,32,1,0,90,36};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){

        if(null  == arr || arr.length < 2){
            return;
        }

        for(int i = 0; i <  arr.length; i++){
            int minIndex = i;

            for(int j = i +1; j < arr.length; j ++ ){

                minIndex = arr[minIndex] > arr[j] ? j : minIndex;

            }

            if(minIndex != i){

                int temp = arr[minIndex];

                arr[minIndex] = arr[i];

                arr[i] = temp;

            }

        }
    }

}
