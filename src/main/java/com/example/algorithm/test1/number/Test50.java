package com.example.algorithm.test1.number;

/**
 * @author: heshineng
 * @createdBy: 2020/5/22 15:52
 */
public class Test50 {
    /**
     * 题目描述
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */

    public static void main(String[] args) {
        Test50 test50 = new Test50();
        int[] array = {2, 6, 7, 5, 4, 3, 6, 8, 2};
        int[] array1 = {2, 6, 7, 6, 2, 3, 6, 8, 2};
        int[] array2 = {2, 1, 3, 6, 2, 3, 6, 8, 2};

        System.out.println(test50.duplicate(array2));
    }

    //使用计数法，记录出现的次数 使用额外的数组标记
    private int repeatNum(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int[] countArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
            if (countArray[array[i]] > 1) {
                return array[i];
            }
        }
        return -1;

    }

    /**
     * 只能找到人一个一个重复的数，不能找到第一个重复的数
     * 在数组本身做操作，不需要二外空间，做比较交换
     * 把每一个数按index 下标，放在该放的位置，如果位置上已经有值，代表重复
     * @param array
     * @return
     */
    private int repeatNum1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == array[i]) {
                //数字本身在当前位置，不做处理
                continue;
            }
            int result = array[i];
            //数字不再当前位置，放大该放的位置
            if (result == array[result]) {
                //如果数据放到该放的位置值相等，代表有重复
                return array[i];
            } else {
                //交换
                array[i] = array[result];
                array[result] = result;
            }
        }
        return -1;

    }


    /**
     * 这个方式没有用额外的空间，但是不能找到第一个重复的数，是任意一个
     * @param numbers
     * @return
     */
    public int duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] == index) { // 当前下标index的值刚好为index
                index++;
            } else {
                int tmp = numbers[index];
                if (tmp == numbers[tmp]) { // 要交换位置的两个数相同
                    return tmp;
                } else { // 交换位置
                    numbers[index] = numbers[tmp];
                    numbers[tmp] = tmp;
                }
            }
        }
        return -1;
    }
}
