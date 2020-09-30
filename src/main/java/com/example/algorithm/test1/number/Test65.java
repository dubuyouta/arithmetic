package com.example.algorithm.test1.number;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: heshineng
 * @createdBy: 2020/6/8 10:55
 */
public class Test65 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     *
     * 本题的题意，就是通过insert() 方法动态改变数据流元素，并且getMedian()动态获取需要的中位数
     * 动态求中位数
     */
    public static void main(String[] args) {
        Test65 test65 = new Test65();

        for(int i=1;i<9;i++){
            test65.insert(i);
            System.out.println(test65.getMedian());
        }
    }

    //优先队列-默认小顶堆 存放有序的数组后半部分数据
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //优先队列-默认大顶堆 存放有序的数组前半部分数据
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //记录数据总数
    int count = 0;

    /**
     * 该题解题思路，使用java 的优先队列 PriorityQueue
     * 使用小顶堆，存放有序数据的后半部分数据
     * 使用大顶堆，存放有序数据的前半部分数据
     * 这样奇数个数，就从小顶堆获取
     * 偶数个 个数，就从大顶堆和小顶堆求和平均值
     *
     * 每次插入小顶堆数，是大顶堆的最大值，(即大顶堆的堆顶)
     * 每次插入大顶堆，是小顶堆的的最小值  (即小顶堆的堆顶)
     *
     * 如果是奇数，优先插入小顶堆，总保持小顶堆数量>=大顶堆
     * 如 1 2 3 4 5 6 7 8
     * minHead==> 5 6 7 8
     * maxHead==> 4 3 2 1
     */
    private void insert(int num) {
        //计算加入后数值的大小
        count++;
        //加入元素后，队列变为奇数个元素，往小顶堆加数据
        if ((count & 1) == 1) {
            //先将数据加入大顶堆
            maxHeap.offer(num);
            //大顶堆最大数据出队
            int max = maxHeap.poll();
            //将大顶堆最大数据,加入小顶堆
            minHeap.offer(max);
        } else {
            //加入元素后，队列变为偶数个元素，往大顶堆加数据
            //先将数据加入小顶堆
            minHeap.offer(num);
            //小顶堆最小数据出队
            int min = minHeap.poll();
            //将最小元素，加入大顶堆
            maxHeap.offer(min);
        }
    }

    private int getMedian() {
        if ((count & 1) == 1) {
            //奇数个元素
            return minHeap.peek();
        } else {
            //偶数个元素
            return (minHeap.peek() + maxHeap.peek()) >> 1;
        }
    }


}
