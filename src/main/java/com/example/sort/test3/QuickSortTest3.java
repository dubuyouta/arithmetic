package com.example.sort.test3;

import java.util.Arrays;

public class QuickSortTest3 {

    public static void main(String[] args) {
        QuickSortTest3 test = new QuickSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        test.test(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快排 比较交换排序
     * 找到中间的基准数据，然后2端递归处理
     */
    private void test(int[] array, int low, int high) {
        if (array == null || array.length < 2) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left=low;
        int right=high;
        //基准选择最小
        int temp=array[left];
        while (left<right){
            while (left<right&&array[right]>=temp){
                //右边的数 仍然比 左边的大，说明基准值还要向左找
                right--;
            }
            array[left]=array[right];
            while (left<right&&array[left]<=temp){
                //左边的数任然小于，继续向右找
                left++;
            }
            array[right]=array[left];
        }
        array[left]=temp;
        test(array,low,left-1);
        test(array,left+1,high);
    }
}
