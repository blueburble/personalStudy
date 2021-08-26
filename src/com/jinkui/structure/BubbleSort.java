package com.jinkui.structure;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
            int[] list = new int[]{3,4,6,1,9,80};
            bubbleSort(list);
            System.out.println(Arrays.toString(list));

    }

    /**
     * 冒泡排序
     *  时间复杂度 n²
     *  最好 n
     *  最坏 n²
     *  空间复杂度O(1)
     *   稳定排序算法
     *   平均复杂度       数据有序度 为 n(n - 1)/2    所以平均有序度 为 n(n - 1)/4    这仅仅只是交换 所以 平均复杂度为 n
     *
     *
     *
     * @param list
     */

    static  void bubbleSort(int[] list){
        //判断数据长度
        if(null == list || list.length <= 1){
            return;
        }
        //遍历 开始 处理数据
        for(int i = 0; i < list.length; i++){
            //判断是否需要交换
            Boolean changeFlag = false;
            for(int j = 0; j < list.length - 1 - i; j++){
                if(list[j] > list[j + 1]){
                    int temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    changeFlag = true;
                }
            }
            //判断是否有数据交换
            if(!changeFlag){
                break;
            }
        }
    }

}
