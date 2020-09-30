package com.example.sort.test;

import com.alibaba.fastjson.JSON;

public class HeapSortTest {
    /**
     * 堆排序
     * 堆的定义如下：n个元素的序列{k1,k2,···,kn}，当且仅当满足下关系时，称之为堆。
     * <p>
     * ki <= k(2i)  且   ki <= k(2i+1)
     * <p>
     * 或：   ki >= k(2i) 且 ki >= k(2i+1)
     * <p>
     * 此序列对应的二维数组看成一个完全二叉树:
     * 完全二叉树中任何一个非叶子节点的值均不大于（或不小于）其左，右孩子节点的值
     * <p>
     * 此处以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，
     * 选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序。
     */

    public static void main(String[] args) {
        HeapSortTest test = new HeapSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.heapSort(array)));

    }

    /**
     * 堆排序分2步，首先构建大顶堆，
     * 再将 堆顶 与 kn交换
     * 再构建 ，在交换
     *
     * 时间复杂度 最好=O(nlog₂n) 平均=O(nlog₂n) 最坏=O(nlog₂n)
     * 空间复杂度 O(1)
     * 不稳定排序
     *
     * @param array
     * @return
     */
    public int[] heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int heapSize = array.length; heapSize > 0; heapSize--) {
            //构建大顶堆
            /**
             * int[k]>=int[2k] &&int[k]>=int[2k+1]
             */
            buildMaxHeap(array, heapSize);
            //交换,每次堆顶与最后一个元素交换
            int temp = array[0];
            array[0] = array[heapSize - 1];
            array[heapSize - 1] = temp;
        }
        return array;

    }

    public void buildMaxHeap(int[] array, int heapSize) {
        //首先找到一半的位置
        for (int i = heapSize / 2; i >= 0; i--) {
            /**
             * 从后往前构建大的堆
             */
            //暂存最大元素
            int maxIndex = i;
            //如果有左子树，并且左子树比父节点大，记录左子树
            if (i * 2 < heapSize && array[i * 2] > array[maxIndex]) {
                maxIndex = i * 2;
            }
            //如果有右子树，并且右子树比父节点大，记录右子树
            if (i * 2 + 1 < heapSize && array[i * 2 + 1] > array[maxIndex]) {
                maxIndex = i * 2 + 1;
            }

            if (i != maxIndex) {
                //交换
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }


    }
}
