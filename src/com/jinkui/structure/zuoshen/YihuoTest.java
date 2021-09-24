package com.jinkui.structure.zuoshen;

import java.util.Arrays;

/**
 * 一堆数
 *
 * 1)   一堆数里面   有奇数次的一个数 和 偶数次的一个数 求出这个数
 * 2)   一堆数里面 有奇数次的两个数 和偶数次的其他书 求出这两个数
 *
 */
public class YihuoTest {

    public static void main(String[] args){

        int[] list = {1,2,4,4,5,2,1,7,7,8,8,9,9};

        System.out.println(getSingleNum(list));;

        int[] list2 = {1,2,4,4,5,2,1,7,7,8,8,9,9,10};

        System.out.println(Arrays.toString(getTwoSingleNum(list2)));;
    }


    private static int getSingleNum(int[] list){
        int temp = 0;
        for(int num: list){
            temp ^= num;
        }
        return temp;
    }

    private static int[] getTwoSingleNum(int[] list){

        int num = 0;
        int numTemp = 0;


        for(int n : list){
            // a ^ b    并且 a != b  所以  num > 0       num 某一位必须不等于0
            num ^= n;
        }

        int rightOne = num & (~num + 1);

        for(int n : list){
            if((rightOne & n) == 0){
                numTemp ^= n;
            }
        }

        return new int[]{numTemp, numTemp^num};


    }

}
