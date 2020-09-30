package com.example.sort.test3;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class MergeSortTest3 {

    public static void main(String[] args) {
        MergeSortTest3 test = new MergeSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.test(array)));
    }

    private int[] test(int[] array) {
        /**
         * 将数组完全分成折半分2个数组，然后
         * 2个数组分别递归最后，将数组合并
         */
        if (array == null || array.length < 2) {
            return array;
        }
        int half = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, half);
        int[] rightArray = Arrays.copyOfRange(array, half, array.length);
        return mergeTowArray(test(leftArray), test(rightArray));
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        /**
         * 2个数组都已经有序，分别合并成一个新的数组
         */
        int[] resultArray = new int[leftArray.length + rightArray.length];
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (resultIndex < resultArray.length) {
            /**
             * 此处要分清楚，一旦一个一个数组执行完，要续上另一个数组
             */

            if (leftIndex >= leftArray.length) {
                resultArray[resultIndex] = rightArray[rightIndex];
                rightIndex++;
                resultIndex++;
                continue;
            }
            if (resultIndex >= resultArray.length) {
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
                resultIndex++;
                continue;
            }
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
                resultIndex++;
            } else {
                resultArray[resultIndex] = rightArray[rightIndex];
                rightIndex++;
                resultIndex++;
            }
        }
        return resultArray;
    }

    private int[] merge1(int[] leftArray, int[] rightArray) {
        /**
         * 2个数组都已经有序，分别合并成一个新的数组
         */
        /**
         * 合并数列写的不精练
         *
         * 合并2个数组的要点：2个数组指针都向右移动，小的数据赋值，继续移动，
         * 否则换另一个数组移动
         * 当一个移动完后，剩下所有的全部补齐
         */
        int[] resultArray = new int[leftArray.length + rightArray.length];
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (resultIndex < resultArray.length) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                    resultArray[resultIndex] = leftArray[leftIndex];
                    leftIndex++;
                    resultIndex++;
                } else {
                    resultArray[resultIndex] = rightArray[rightIndex];
                    rightIndex++;
                    resultIndex++;
                }
            } else {
                if (leftIndex >= leftArray.length) {
                    resultArray[resultIndex] = rightArray[rightIndex];
                    rightIndex++;
                    resultIndex++;
                } else {
                    resultArray[resultIndex] = leftArray[leftIndex];
                    leftIndex++;
                    resultIndex++;
                    continue;
                }
            }
        }
        return resultArray;
    }

    private int[] mergeTowArray(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[leftArray.length + rightArray.length];
        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (leftIndex >= leftArray.length) {
                resultArray[i] = rightArray[rightIndex];
                rightIndex++;
            } else if (rightIndex >= rightArray.length) {
                resultArray[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                resultArray[i] = leftArray[leftIndex];
                leftIndex++;
            } else {
                resultArray[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        return resultArray;
    }
}
