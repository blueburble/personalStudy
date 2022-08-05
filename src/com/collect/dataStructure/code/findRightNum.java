package com.collect.dataStructure.code;

public class findRightNum {

    public static void main(String[] args){
        int[] arr = {4,5,5,5,7,8,9,12,12};

        System.out.println(findBigLeftValue(arr, 5));
    }

    public static int findBigLeftValue(int arr[], int num){
        int left = 0;
        int right = arr.length - 1;

        int findFlag = -1;

        while(left < right){

            int mid = left + ((right - left) >> 1);

            if(arr[mid] == num){
                findFlag = mid;
                right = mid - 1;
            }

            if(arr[mid] > num){
                right = mid -1;
            }

            if(arr[mid] < num){
                left = mid + 1;
            }
        }

        return findFlag;

    }
}
