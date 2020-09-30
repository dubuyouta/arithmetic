package com.example.algorithm.test3;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/17
 */
public class Test6 {

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(test6.nextMax(array)));
    }

    private int[] nextMax(int[] array) {
       if(array==null||array.length==0){
           return null;
       }
        //从右往左找到第一个升序的数
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        int index = i - 1;
        if (index < 0) {
            return null;
        }
        //从右往左，找到第一个比 index大的数下标
        int j = array.length - 1;
        for (; j >= 0; j--) {
            if (array[j] > array[index]) {
                break;
            }
        }
        //交换
        int temp = array[index];
        array[index] = array[j];
        array[j] = temp;
        //反转index后面的数
        int start = index+1, end = array.length - 1;
        for (; start < end; start++, end--) {
            int x = array[start];
            array[start] = array[end];
            array[end] = x;
        }
        return array;
    }
}
