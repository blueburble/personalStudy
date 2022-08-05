package com.collect.dataStructure.code;

import java.util.Arrays;

/**
 * <=  || >
 */


/**  模拟过程   num --> 4
 *  ) 5 1 4 4 1 10 3 3
 *  开始
 *  ) 五 1 4 4 1 10 3 3
 *  ) 5 一 4 4 1 10 3 3
 *  交换
 * 1) 五 4 4 1 10 3 3
 * 1) 5 四 4 1 10 3  3
 * 1 4）五 4 1 10 3 3
 * 1 4  ) 5 四 1 10 3 3
 * 交换
 * 1 4 4) 五 1 10 3  3
 * 1 4 4) 5   一 10 3   3
 * 交换
 * 1 4  4 1) 五 10 3 3
 * 1 4 4 1)  5十  3  3
 * 1 4 4 1)  5  10 三 3
 * 交换
 * 1 4 4 1 3) 10  五  3
 * 1 4  4 1 3 ) 10  5 三
 * 交换
 * 1 4 4 1 3 3) 5 十
 *
 * 结束
 *
 */
public class helanguoqi1 {

    public static void main(String[] args){
        int[] arr = new int[]{5,1,4,4,1,10,3,3};
        arr = convert(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] convert(int[] arr, int num){
        if(arr == null || arr.length < 1){
            return arr;
        }
        int lastEqual = -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            // 如果大于的话 left++
            if(arr[left] > num){
                left++;
            }else{
                //如果 <= 跟小于等于区的下一个数交换 同时 <= 区 右扩
                swap(arr, ++lastEqual, left);
            }
        }
        return arr;
    }


    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
