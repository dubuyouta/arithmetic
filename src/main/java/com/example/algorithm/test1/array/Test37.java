package com.example.algorithm.test1.array;

/**
 * @author: heshineng
 * @createdBy: 2020/5/7 18:12
 */
public class Test37 {

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     *  首先这个数组时排序的，所以可以使用二分查找
     * 思路：首先使用二分查找， 确定元素是否存在数组中，计算位置 时间复杂度 logn
     *  2.根据这个元素往前找所有元素数
     *  3.根据这个元素位置往后找所有元素数
     *
     */

    public static void main(String[] args) {
        Test37 test37 = new Test37();
        //int[] array={1,5,6,8,9,10,11,12,13,13,13,14,15};
        //int[] array={15,14,13,13,13,12,11,10,9,8,6,5,1};
        int[] array={13,13,13,13,13};
        System.out.println(test37.getNumberOfK(13,array));
    }

    private int getNumberOfK(int num, int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //先判断数组时升序还是降序
        int low = 0;
        int high = array.length - 1;
        if (array[low] == array[high]) {
            //说明所有数组元素都一样
            if (num == array[low]) {
                return array.length;
            } else {
                return 0;
            }
        }

        int index = binarySearch(num, array, array[low] < array[high]);
        if (index < 0) {
            return 0;
        }
        int number = 1;
        for (int i = index + 1; i < array.length && num == array[i]; i++, number++) {
        }
        for (int j = index - 1; j > 0 && num == array[j]; j--, number++) {
        }
        return number;
    }

    private int binarySearch(int num, int[] array, boolean asc) {
        if (array == null || array.length == 0) {
            return -1;
        }
        //先判断数组时升序还是降序
        int low = 0;
        int high = array.length - 1;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (array[mid] == num) {
                return mid;
            } else if (array[mid] > num) {
                if (asc) {
                    //升序 往左找
                    high = mid - 1;
                } else {
                    //降序 往右找
                    low = mid + 1;
                }
            } else {
                //中间值比 找的值小
                if (asc) {
                    //升序 往右找
                    low = mid + 1;
                } else {
                    //降序 往左找
                    high = mid - 1;
                }
            }
            mid = low + (high - low) / 2;
        }
        return -1;

    }
}
