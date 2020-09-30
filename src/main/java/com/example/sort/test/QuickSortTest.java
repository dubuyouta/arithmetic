package com.example.sort.test;

import com.alibaba.fastjson.JSON;

public class QuickSortTest {
    /**
     * 快速排序--交换比较排序
     * 快速排序，分治思想
     * <p>
     * 选择一个基准，一把选择首个数字
     * 通过一趟排序将待排记录分隔成独立的两部分
     * 所有小于基准数放在左边，大于基准数的放右边
     * 然后递归左边 右边的数列，直到有序
     */
    public static void main(String[] args) {
        QuickSortTest sortTest = new QuickSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        sortTest.quickSort(array, 0, array.length - 1);
        System.out.println(JSON.toJSONString(array));
    }

    /**
     * 时间复杂度： 平均=O(nlog₂n) （log以2为底的n） 最好=O(nlog₂n)  最坏=O(n²)
     * 空间复杂度： O(1) （原地递归）
     * 左右交换，可能交换相等值，所以不稳定排序
     *
     *
     * 快速排序（递归）
     * 从数列中挑出一个元素，称为"基准"（pivot）
     * 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
     * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
     * <p>
     * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序
     * <p>
     * 具体做法，就是通过一遍循环找到基准值得位置
     *
     * @param array 数组
     * @param low   左边 低位
     * @param high  右边 高位
     * @return
     */
    public void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        //一般选择首个数字
        int left = low;//左右2个指针变动
        int right = high;
        int temp = array[left];//基准值
        while (left < right) {
            //这样左右逼近，是为了找到基准值的位置
            while (left < right && array[right] >= temp) {
                //如果数列右边的数大于基准值，右指针还可以左偏移，指针减1
                right--;
            }
            //跳出循环，说明此时右边的数比左边数小，需要将右边数调整到左边
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                //如果数列左边的数小于基准值，左指针可以右移，指针加1
                left++;
            }
            //跳出循环，说明此时左边数比基准值大，需要将左边数调整到右边
            array[right] = array[left];
        }
        //大循环跳出，说明找到中间基准位置，left=right ，分成左右2个数组

        //将基准值放在中间位置
        array[left] = temp;
        System.out.println(JSON.toJSONString(array));

        quickSort(array, low, left - 1);//左边数列继续递归 留下中间一个位置
        quickSort(array, left + 1, high);//右边数列继续递归
    }


}
