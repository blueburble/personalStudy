package com.jinkui.structure.MyTest;

public class MinSumQuestion {

    public static void main(String[] args){

        int[] test = {1,2,4,3,5};
        System.out.println(processMinSum(test));

    }

    public static int processMinSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return  process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L)>>1);
        return process(arr,L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        int result = 0;
        while(p1 <= M && p2 <= R){
            result += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]  : arr[p2++];
        }
        while(p1 <= M){
            help[i++] =  arr[p1++];
        }
        while (p2 <= R){
            help[i++] =  arr[p2++];
        }

        for(int j = 0; j < help.length; j++){
            arr[L + j] = help[j];
        }
        return result;
    }

}
