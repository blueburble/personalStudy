package com.jinkui.day2;

public class midSumQuestion {
    public static void main(String[] args){
        int[] arr = new int[]{1,7,9,10}; // 小和 26  1 +1 + 7 + 1+7 +9

        System.out.println(caculateMinSum(arr, 0,  arr.length - 1));
    }

    static int caculateMinSum(int arr[], int left, int right){
        if(left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return caculateMinSum(arr, left, mid) + caculateMinSum(arr, mid +1, right) + merge(arr, left, mid, right);
    }


    static int merge(int[] arr, int left, int middle, int right){
      int p1 = left;
      int p2 = middle +1;
      int minSum = 0;
      int index = 0;
      //临时数组
      int arrTemp[] = new int[right - left + 1];
      while(p1 <= middle && p2 <= right){
          minSum += arr[p1] < arr[p2] ? (right  - p2 + 1) * arr[p1] : 0;
          arrTemp[index++] =  arr[p1] < arr[p2] ? arr[p1++]: arr[p2++];
      }

        while(p1 <= middle){
          arrTemp[index++] =  arr[p1++];
        }

        while(p2 <= right){
            arrTemp[index++] =  arr[p2++];
        }

        for(int i = 0; i < arrTemp.length; i++){
            arr[left + i] = arrTemp[i];
        }

    return minSum;
    }

}
