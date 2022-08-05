package com.jinkui.day1;

public class findOneNum {
    public static void main(String[] args){
        int arr[] = {1, 1,2,4,6,7,10,10,21,30};

      /*  System.out.println(findNum(arr, 4));*/

        // find >= 最左边
        System.out.println(findLeftNum(arr, 10));

        int arr2[] = {4,5,5,6,7,8};
        System.out.println(findJubuMinNum(arr2));

    }

    public static int  findNum(int[] arr, int num){

        int midIndex = arr.length / 2;

        int temp = arr[midIndex];

        while(temp != num){
            if(temp > num){
                midIndex = midIndex / 2;
            }
            if(temp < num){
                midIndex = (arr.length -  midIndex)  / 2;
            }

            temp = arr[midIndex];
        }

        return temp;
    }

    public static int findLeftNum(int[] arr, int num){

        int start = 0;
        int midIndex = arr.length / 2;
        int end = arr.length - 1;

        int target = -1;
        while(start < midIndex){
            if(arr[midIndex] >= num){
                target = midIndex;
                end = midIndex;
            }
            if(arr[midIndex] < num){
                start = midIndex;
            }

            midIndex  = (start +end) /2;
        }

       return target;


    }

    public static int findJubuMinNum(int[] arr){
        if(arr == null || arr.length < 1){
            return -1;
        }
        if(arr[0] < arr[1]){
            return arr[0];
        }
        if(arr[arr.length -1] < arr[arr.length - 2]){
            return arr[arr.length - 1];
        }
        int start = 1;
        int end  = arr.length - 2;
        int mid = -1;
        while (start < end){
             mid = (end - start)/ 2;
            if(arr[mid] > arr[mid -1]){
                end = mid;
            }else if (arr[mid] >arr[mid +1]){
                start = mid;
            }else{
                return  mid;
            }
        }
        return mid;
    }
}
