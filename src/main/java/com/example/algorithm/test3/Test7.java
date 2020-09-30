package com.example.algorithm.test3;

/**
 * @author heshineng
 * created by 2020/9/19
 */
public class Test7 {

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        int[] array = {1, 2, 3, 1, 5, 6, 7, 3, 5};
        System.out.println(test7.maxLength(array));
    }

    public int maxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length < 2) {
            return arr.length;
        }
        int max = 0;
        int slow = 0, fast = 1;
        while (fast < arr.length) {
            int i = fast - 1;
            for (; i >= slow && arr[fast] != arr[i]; i--) {

            }
            if (i < slow) {
                i = slow;
            }
            max = Math.max(max, fast - i + 1);
            if (arr[fast] == arr[i]) {
                slow = i + 1;
            }
            fast++;
        }
        return max;
    }
}
