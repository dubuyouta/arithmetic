package com.example.arithmetic.interview;

/**
 * 132模型
 *
 * @author xiaobao.chen
 * Create at 2020-10-20
 */
public class byteinterview001 {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 6};
        System.out.println(hasSubMode(array));
    }

    public static boolean hasSubMode(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        for (int i = 0; i < array.length - 2; i++) {
            int end = array.length - 1;
            int mid = end - 1;

            while (mid > i) {
                if (array[i] < array[end]) {
                    if (array[end] < array[mid]) {
                        return true;
                    } else {
                        mid--;
                    }
                } else {
                    end--;
                    mid--;
                }
            }
        }
        return false;
    }
}
