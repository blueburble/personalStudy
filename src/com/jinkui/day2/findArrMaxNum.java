package com.jinkui.day2;

public class findArrMaxNum {


    public static void main(String[] args){

        int arr[] = {5,1,10,90,100,1000,5,7, 3000};

        System.out.println(findMaxNum(arr, 0, arr.length - 1));
    }

     static  int findMaxNum(int arr[], int left, int right){

        if(left == right){
            return arr[left];
        }

        int mid = left + ((right - left) >> 1);

        int leftMax = findMaxNum(arr, left, mid);

        int rightMax = findMaxNum(arr, mid +1, right);

        return Math.max(leftMax, rightMax);
    }
}