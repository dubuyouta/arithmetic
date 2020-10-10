package com.example.arithmetic.arithmeticstu.base;

/**
 * 二分查找--折半查找
 * 前提条件：数据是有序的。
 * 原理：二分查找的每次都从中间查找，如果比中间小，就去左边，如果比中间大，就去右边
 *
 * @author xiaobao.chen
 * Create at 2020-05-24
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {2, 5, 7, 9, 11, 14, 20, 25, 30};
        System.out.println(binarySearch(a, 5));
        System.out.println(binarySearch1(a, 5));
        System.out.println(binarySearch(a, 0, a.length - 1, 5));
    }

    public static int binarySearch1(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        /**防止int类型数据长度溢出*/
        int mid = left + (right - left) / 2;
        /**<= 防止特殊情况出现*/
        while (left <= right) {
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

    public static int binarySearch(int[] a, int r) {
        int h = 0;
        int e = a.length - 1;
        while (h < e) {
            int mid = (h + e) / 2;
            if (r == a[mid]) {
                return mid;
            } else if (r < a[mid]) {
                e = mid - 1;
            } else if (r > a[mid]) {
                h = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] a, int low, int height, int r) {
        int mid = (low + height) / 2;
        if (low > height) {
            return -1;
        }
        if (a[mid] == r) {
            return mid;
        }
        if (r < a[mid]) {
            return binarySearch(a, low, mid - 1, r);
        }
        if (r > a[mid]) {
            return binarySearch(a, mid + 1, height, r);
        }
        return -1;
    }
}
