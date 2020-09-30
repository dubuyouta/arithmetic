package com.example.algorithm.test2.stack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2020/7/27 13:17
 */
public class Test15 {
    /**
     * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，
     * 当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
     *
     * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，
     * 若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
     * 请返回一个int[][]，
     * 为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
     *
     * int[][2] ope 代表 n列 2行的一个二维数组
     * 如： 1  2  2  1
     *      2  3  5  4
     *
     *      其中ope[i][0] 其中第0行，代表操作类型，只有 1 和 2
     *      其中 ope[i][0]=1 代表 push操作；ope[i][1]=4 这个代表需要push进栈的数
     *
     *      ope[i][0]=2 代表出栈，ope[i][1] 代表的数无意义
     *
     *      所以使用 ope[n][2] 使用 n列2行的一系列操作，返回操作后的结果
     *
     */

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        int[][] array = new int[10][2];
        array[0] = new int[]{1, 1};
        array[1] = new int[]{1, 2};
        array[2] = new int[]{2, 3};
        array[3] = new int[]{1, 4};
        array[4] = new int[]{1, 5};
        array[5] = new int[]{2, 6};
        array[6] = new int[]{1, 7};
        array[7] = new int[]{2, 8};
        array[8] = new int[]{1, 9};
        array[9] = new int[]{1, 10};
        /**
         * 结果
         * 1 4 9 10
         */
        SetOfStacks setOfStacks = test15.get(array, 2);
        while (!setOfStacks.isEmpty()) {
            System.out.println(setOfStacks.pop());
        }

        System.out.println(JSON.toJSONString(test15.get1(array, 2)));


    }

    //使用list实现
    private List<List<Integer>> get1(int[][] array, int size) {
        if (array == null || array.length == 0 || array[0].length != 2) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 1) {
                //push
                if (list.size() == 0 || list.get(list.size() - 1).size() == size) {
                    list.add(new ArrayList<>(size));
                }
                list.get(list.size() - 1).add(array[i][1]);
            } else if (array[i][0] == 2) {
                //pop
                if(list.size()==0){
                    throw new IllegalStateException("没有可以出栈的数");
                }
                if(list.get(list.size() - 1).size()==0){
                    list.remove(list.size() - 1);
                }
                List<Integer> cur=list.get(list.size() - 1);
                cur.remove(cur.size()-1);
            }
        }
        return list;
    }

    private SetOfStacks get(int[][] array, int size) {
        if (array == null || array.length == 0 || array[0].length != 2) {
            return null;
        }
        SetOfStacks setOfStacks = new SetOfStacks(size);
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 1) {
                //push
                setOfStacks.push(array[i][1]);
            }
            if (array[i][0] == 2) {
                //pop
                setOfStacks.pop();
            }
        }
        return setOfStacks;
    }

    class SetOfStacks {

        private int size;

        private List<Stack<Integer>> list;

        private int currentSize;

        private Stack<Integer> currentStack;

        public SetOfStacks(int size) {
            this.size = size;
            this.list = new ArrayList<>();
        }


        public void push(int num) {
            if (currentSize == size) {
                //一个栈满
                list.add(currentStack);
                currentSize = 0;
            }
            if (currentSize == 0) {
                currentStack = new Stack<>();
            }
            currentStack.push(num);
            currentSize++;
        }

        public int pop() {
            if (currentSize == 0) {
                if (list.size() == 0) {
                    throw new IllegalStateException("没有可以出栈的数");
                }
                currentStack = list.remove(list.size() - 1);
                currentSize = size;
            }
            currentSize--;
            return currentStack.pop();
        }

        public boolean isEmpty() {
            if (currentSize > 0) {
                return false;
            }
            if (list.size() > 0) {
                return false;
            }
            return true;
        }
    }


}
