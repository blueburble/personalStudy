package com.jinkui.structure.MyTest;

import java.nio.file.Path;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,1,9,32,1,0,90,36};
        process(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void process(int[] arr, int L , int R){
        //终止条件
        if(L == R){
            return ;
        }
        int mid = L + ((R - L) >>1);
        process(arr, 0 ,  mid);
        process(arr, mid +1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] list, int L , int M, int R){
        int[] arr_temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M +1;
        while(p1 <= M && p2 <= R){
            arr_temp[i ++] = list[p1] <= list[p2] ? list[p1 ++] :  list[p2 ++];
        }

        while(p1 <= M){
            arr_temp[i ++] = list[p1 ++];
        }

        while(p2 <= R){
            arr_temp[i ++] = list[p2 ++];
        }

        for(int k = 0; k < arr_temp.length; k ++){
            list[L + k] =  arr_temp[k];
        }
    }
}
