package com.jinkui.day1;

public class findOneJishu {
    public static void main(String[] args){
        int[] arr = {1,1,4,2,2,7,7};
        System.out.println(findSingOne(arr));
    }

    public static int findSingOne(int[] arr){
        int eor = 0;
        for(int i : arr){
            eor ^= i;
        }
        return eor;
    }
}
