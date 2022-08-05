package com.jinkui.day2;
;
public class ReverseOrderSum {


    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 1, 9, 0, 30}; //逆序对 (5，2)     (5，1)  5,0 21 20  10 90
        System.out.println(caculateReverseNum(arr));
    }

    static int caculateReverseNum(int[] arr){
        if(null == arr || arr.length < 2){
            return 0;
        }
        return countReverseNum(arr, 0, arr.length - 1);
    }

    static int countReverseNum(int[] arr, int left, int right){
        if(left == right){
            return 0;
        }
        int mid = left  + ((right - left) >> 1);
        return countReverseNum(arr, left, mid) + countReverseNum(arr, mid +1, right) + merge(arr, left, mid, right);
    }

    static int merge(int[] arr, int left, int mid, int right){
        int p1 = left;
        int p2 = mid + 1;
        int reverseNum = 0;
        int index = 0;
        int[] arrTemp = new int[right - left + 1];
        while(p1 <= mid && p2 <= right){
            reverseNum +=  arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            arrTemp[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            arrTemp[index++] = arr[p1++];
        }
        while(p2 <= mid){
            arrTemp[index++] = arr[p2++];
        }
        for(int i = 0; i < arrTemp.length; i++){
            arr[i + left] =  arrTemp[i];
        }
        return reverseNum;
    }
}