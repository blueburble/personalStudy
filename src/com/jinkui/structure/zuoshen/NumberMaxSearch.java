package com.jinkui.structure.zuoshen;


/**
 * 递归求数组最大值
 *     T(n) 母问题的数据量n级别的
 *     T（n/b) 子问题的数据规模
 *     a 子问题被调用了多少次
 *     除去子问题调用之外的时间复杂度
 *      MASTER公式    T(n) = a * T（n/b) + O（n ^ D）
 *      推理如下:
 *      logb (a)  <  d          O(N  ^ D)
 *      logb (a)  >  d          O(N ^ (log b (a) ) )
 *      logb (a)  =  d          O(N ^ d *  log(N) )
 */
public class NumberMaxSearch {

    public static void main(String[] args) {
        int[] array = new int[]{3,1,4,5,2,2,1,90,3};
        System.out.println(process(array));
    }


    public static int process(int[] array){
        return getMax(array, 0, array.length - 1);
    }

    public static int getMax(int[] array, int l, int r){
        if(l == r){
            return array[l];
        }
        int middle = l + ((r - l) >> 1);
        int leftMax = getMax(array, l , middle);
        int rightMax = getMax(array, middle + 1, r);
        return Math.max(leftMax, rightMax);
    }
    // T(n) = 2 * T（n/2) + O（n ^ 0）
    // T(n) = 2 * T（n/2) + O（1）
}
