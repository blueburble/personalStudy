package com.jinkui.structure.MyTest;

public class MaxNumberQuery {

    public static void main(String[] args){
        int[] arr = {3,1,9,32,1,0,90,36};
        System.out.println(getMax(arr,0,arr.length - 1));
    }

    public static int getMax(int[] arr, int L, int R){

        if(L == R){
            return  arr[L];
        }

        int M = L + ((R - L) >> 1);

        int leftMax = getMax(arr, 0 , M);

        int rightMax = getMax(arr, M + 1, R);

        return Math.max(leftMax, rightMax);

    }


}
