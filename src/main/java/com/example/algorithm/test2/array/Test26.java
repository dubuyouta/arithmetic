package com.example.algorithm.test2.array;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class Test26 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置-对二分法查找的改造
     *
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 输入: nums = [5,7,7,8,8,10],
     * target = 8
     *
     * 输出: [3,4]
     *
     * 输入: nums = [5,7,7,8,8,10],
     * target = 6
     *
     * 输出: [-1,-1]
     *
     */

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        int[] array = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(test26.searchRange(array, 8)));
        System.out.println(Arrays.toString(test26.searchRange1(array, 8)));
    }

    private int[] searchRange(int[] array, int target) {
        int index = binarySearch(array, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        //向左找
        int left = index;
        while (left >= 0 && array[left] == target) {
            left--;
        }
        //向右找
        int right = index;
        while (right < array.length && array[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    private int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (array[mid] > target) {
                //向左
                right = mid - 1;
            } else if (array[mid] < target) {
                //向右
                left = mid + 1;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

    private int[] searchRange1(int[] array, int target) {
        int index = binarySearch(array, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        //向左找
        int first = binarySearchFirst(array, target);
        if (array[first] == target) {
            int last = binarySearchLast(array, target);
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }

    //查到第一个的数
    private int binarySearchFirst(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (array[mid] < target) {
                //向左
                left = mid + 1;
            } else {
                //大于等于，但可能不是第一个，需要继续向左逼近
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }

    //查找最后一个数
    private int binarySearchLast(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (array[mid] <= target) {
                //不是最后一个，继续向右逼近
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return right;
    }


}
