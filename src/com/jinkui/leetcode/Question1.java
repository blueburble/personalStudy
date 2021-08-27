package com.jinkui.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public static void main(String[] args){

    }

    static int[] find(int[] list,  int target){
        if(null == list || list.length <= 1){
            return null;
        }
        Map<Integer,Integer> result = new HashMap<>();
        for(int i = 0; i < list.length; i++){

            if(result.containsKey(list[i])){
                return new int[]{result.get(list[i]), i};
            }

            result.put(target - list[i], i);
        }
        return null;
    }

}
