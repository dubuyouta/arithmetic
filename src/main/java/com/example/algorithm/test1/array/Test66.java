package com.example.algorithm.test1.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: heshineng
 * @createdBy: 2020/6/8 15:18
 */
public class Test66 {
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
     * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */

    public static void main(String[] args) {
        Test66 test66 = new Test66();
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(JSON.toJSONString(test66.slidingMaxWindow(array, 3)));

    }

    /**
     * 使用双向链表操作数据
     * @param array
     * @param size
     * @return
     */
    private List<Integer> slidingMaxWindow(int[] array, int size) {
        if (array == null || array.length == 0 || size == 0) {
            return null;
        }
        if (size == 1) {
            return Arrays.stream(array).boxed().collect(Collectors.toList());
        }
        size = size > array.length ? array.length : size;
        List<Integer> list = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标 维护滑动窗口的下标
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!linkedList.isEmpty() && array[linkedList.peekLast()] < array[i]) {
                /**
                 * 对于即将加入一个新的双向链表的数据，判断即将加入的数据
                 * 比之前加入的数据大，从后往前，将之前数据下标出列
                 *
                 * 这样出队的目的，然队列成为一个 大--> 小的 队列
                 */
                //队尾出列
                linkedList.pollLast();
            }
            //将当前的小标，加入进队列
            linkedList.addLast(i);
            //判断队首元素是否过期
            if (linkedList.peekFirst() == i - size) {
                linkedList.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                list.add(array[linkedList.peekFirst()]);
            }
        }
        return list;
    }

}
