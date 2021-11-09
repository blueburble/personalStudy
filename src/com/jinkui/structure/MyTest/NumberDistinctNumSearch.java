package com.jinkui.structure.MyTest;

import java.util.Arrays;

public class NumberDistinctNumSearch {


    public static void main(String[] args) {
        int[] test = {1,2,4,3,5};
        System.out.println(processDistinctNum(test));
        System.out.println(Arrays.toString(test));
    }

    public static int processDistinctNum(int[] arr){
        if(null == arr || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int middle = L + ((R - L) >> 1);
        return process(arr,L,middle) + process(arr, middle + 1, R) + merge(arr,L,middle,R);
    }

    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R-L + 1];
        int p1 = L;
        int p2 = M +1;
        int i = 0;
        int res = 0;
        while(p1 <= M && p2 <= R){
            if(arr[p1] <= arr[p2]){
                help[i++] =  arr[p1++];
            }else {
                System.out.println(arr[p1] + ">----" + arr[p2]);
                res +=  M - p1 +1 ;
                help[i++] =  arr[p2++];
            }
        }
        while(p1 <= M){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(int j = 0; j < help.length; j ++){
            arr[L + j] = help[j];
        }
        return res;
    }

}
