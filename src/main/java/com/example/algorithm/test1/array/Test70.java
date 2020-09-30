package com.example.algorithm.test1.array;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2020/7/9 16:14
 */
public class Test70 {
    /**
     * 去除一个有序的数组中重复的数，得到数据使得每个数只出现一遍。
     * 并且不借助其他的存储空间 空间复杂度 O（1）
     *
     * 双向指针法：
     */

    public static void main(String[] args) {
        Test70 test70 = new Test70();
        int[] array={1,2,2,4,5,5,8,8,8,9,9,10,11,12};
        System.out.println(test70.removeRepeat(array));
        System.out.println(Arrays.toString(array));
    }

    private int removeRepeat(int[] array){
        if(array==null||array.length==0){
            return -1;
        }
        int slow=0;
        for(int fast=0;fast<array.length;fast++){
            if(array[slow]!=array[fast]){
                slow++;
                array[slow]=array[fast];
            }
        }
        return slow+1;


    }
}
