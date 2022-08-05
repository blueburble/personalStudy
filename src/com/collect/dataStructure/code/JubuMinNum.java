package com.collect.dataStructure.code;

public class JubuMinNum {

    public static void main(String[] args){
        int arr[] = {11,10,9,50,100};
        System.out.println(findJuBuMin(arr, 0, arr.length - 1));
    }

    private static int findJuBuMin(int[] arr, int L, int R){
            if(L == 0 && arr[L] < arr[L + 1]){
                return L;
            }
            if(R == arr.length && arr[R] > arr[R - 1]){
                return R;
            }
            while(L < R){

                int mid = L + ((R - L) >> 1);
                if(arr[mid] > arr[mid - 1]){
                    R = mid  - 1;
                }else if (arr[mid] > arr[mid + 1]){
                    L = mid + 1;
                }else{
                    return mid;
                }
            }
            return -1;
    }
}
