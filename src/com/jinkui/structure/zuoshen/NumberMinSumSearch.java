package com.jinkui.structure.zuoshen;

/**
 * 求数组的小和
 *
 *
 *
 */
public class NumberMinSumSearch {

    public static void main(String[] args) {
            int[] list = {1,3,4,2,5};
            System.out.println(process(list,0 ,list.length - 1));
    }

    public static int process(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L , mid) + process(arr, mid +1, R) + merge(arr, L , mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R){
        int[] arr_temp = new int[R - L + 1];

        int i = 0;
        int p1 = L;
        int p2 = M +1;
        int res = 0;

        while(p1 <= M && p2 <= R){
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            arr_temp[i ++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M){
            arr_temp[i++] = arr[p1 ++];
        }

        while (p2 <= R){
            arr_temp[i++] = arr[p2 ++];
        }

        for(int j = 0; j < arr_temp.length; j++){
            arr[L + j] = arr_temp[j];
        }

        return res;
    }



}
