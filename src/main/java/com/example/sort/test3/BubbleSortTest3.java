package com.example.sort.test3;

import java.util.Arrays;

public class BubbleSortTest3 {

    public static void main(String[] args) {
        BubbleSortTest3 test = new BubbleSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test(array)));
    }

    private int[] test(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
