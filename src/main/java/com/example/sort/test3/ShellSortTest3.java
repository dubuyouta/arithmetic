package com.example.sort.test3;

import java.util.Arrays;

public class ShellSortTest3 {

    public static void main(String[] args) {
        ShellSortTest3 test = new ShellSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test(array)));
    }

    /**
     * 希尔排序 忘记 间隔的递减的层数  （记住步长每次折半，首先length折半）
     *
     * @param array
     * @return
     */
    private int[] test(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        /**
         * 错误 此处直接length-1 即可 它是步长，不可能比原长大
         */
        int gap = (array.length - 1) / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                for (int j = i; j >= 0; j -= gap) {
                    if (j - gap >= 0 && array[j - gap] > temp) {
                        array[j] = array[j - gap];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
            gap /= 2;
        }
        return array;
    }

    private int[] test2(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        /**
         * 错误 此处直接length-1 即可 它是步长，不可能比原长大
         */
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                /**
                 * 更简练写法，直接for循环融合if条件，一般这样不好读
                 */
                for (int j = i; j >= 0; j -= gap) {
                    if (j - gap >= 0 && array[j - gap] > temp) {
                        array[j] = array[j - gap];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
            gap /= 2;
        }
        return array;
    }
}
