package com.example.arithmetic.interview;

/**
 * @author xiaobao.chen
 * Create at 2020-10-20
 */
public class BinarySearch {

    public int binarySearch(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int left = 0;
        int right = num.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else if (num[mid] > target) {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
