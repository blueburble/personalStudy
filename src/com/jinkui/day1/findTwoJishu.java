package com.jinkui.day1;

import java.util.Arrays;

public class findTwoJishu {

    public static void main(String[] args){

        int[] arr = {1,2,2,4,4,6,6,9};

        System.out.println(Arrays.toString(getTwoSingleNum(arr)));


    }


    public static int[] getTwoSingleNum(int[] arr){

        int eor1 = 0;

        for(int i  : arr){
            eor1 ^= i;
        }

        // a^b 有一位必不是 0

        int eor2 = 0;

        // 取最右侧的1
        int temp = eor1 & ( ~eor1 + 1);

        for(int i : arr){
            if((temp & i) == 0){
                eor2 ^= i;
            }
        }

        return new int[]{eor2, eor2 ^ eor1};
    }


}
