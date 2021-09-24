package com.jinkui.structure.zuoshen;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
            int[] arr = {1,3,5,6,6,6,6,6,6,6,1,34,14,15};
            process3(arr,0,arr.length - 1);
            System.out.println(Arrays.toString(arr));
    }

    public static void process(int[] list, int left, int right){
        if(left == right){
            return;
        }

        int middle = left + ((right - left)  >> 1);

        process(list, left, middle);
        process(list, middle +1, right);
        merger(list, left, right, middle);
    }

    public static void merger(int[] arr, int left, int right, int middle){
        int[] arr_tem = new int[right - left + 1];

        int i = 0;
        int p1 = left;
        int p2 = middle +1;

        while(p1 <= middle && p2<= right){
                arr_tem[i ++] = arr[p1] <= arr[p2] ? arr[p1 ++] : arr[p2 ++];
        }

        while (p1 <= middle){
            arr_tem[i++] = arr[p1++];
        }

        while (p2 <= right){
            arr_tem[i++] = arr[p2++];
        }

        for(int k = 0; k < arr_tem.length; k++){
            arr[left + k] = arr_tem[k];
        }
    }


    /**
     * master 公式
     *    T（n) = 2 * T(n/2) +  T（n)
     *
     *   A = 2   N = 2   C = 1
     *
     *
     */

    public static void process2(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int middle = L + ((R - L) >> 1);

        process2(arr, L , middle);
        process2(arr, middle + 1, R);
        merge2(arr, L, middle, R);
    }

    public static void merge2(int[] arr, int L, int M, int R){
        int[] arr_tem = new int[R - L +1];
        int i = 0;
        int p1 = L;
        int p2 = M +1;
        while(p1 <= M && p2 <= R){
            arr_tem[i++] = arr[p1] <= arr[p2] ? arr[p1++]  :  arr[p2++];
        }
        while(p1 <= M){
            arr_tem[i++] = arr[p1++];
        }
        while(p2 <= R){
            arr_tem[i++] = arr[p2++];
        }
        for(int j = 0; j < arr_tem.length; j ++){
            arr[L + j]  = arr_tem[j];
        }
    }



    public static void process3(int[] list, int L, int R){
        if(L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        process3(list, L, mid);
        process3(list, mid + 1, R);
        merge3(list, L, mid, R);
    }

    public static void merge3(int[] list, int L, int M, int R){
        int[] temp = new int[R - L + 1];
        int  p1 = L;
        int p2 = M +1;
        int index = 0;
        while(p1 <= M && p2 <= R){
            temp[index ++] = list[p1] < list[p2] ? list[p1++] : list[p2++];
        }
        while(p1 <= M){
            temp[index ++] = list[p1++];
        }
        while(p2 <= R){
            temp[index ++] = list[p2++];
        }
        for(int i = 0; i < temp.length; i ++){
            list[L + i] = temp[i];
        }
    }
}
