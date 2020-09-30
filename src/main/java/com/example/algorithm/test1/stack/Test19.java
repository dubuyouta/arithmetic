package com.example.algorithm.test1.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 1:32
 */
public class Test19 {
    /**
     * 题目：
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中
     * 所含最小元素的min函数（时间复杂度应为O（1））
     *
     * 优化方向，在使用一个栈作为优化方向
     */

    int[] items;
    int size;
    int min;
    Stack<Integer> minStack=new Stack<>();

    /**
     * 每次只有最小元素入栈
     * @param args
     */

    public static void main(String[] args) {
        Test19 test = new Test19();
        test.push(3);
        test.push(10);
        test.push(2);
        test.push(5);
        test.push(2);

        System.out.println(test.min());

        test.pop();
        test.pop();
        test.pop();
        System.out.println(test.min());

        System.out.println(test.top());
    }

    public Test19() {
        items = new int[16];
        size = 0;
    }

    public synchronized void push(int node) {
        //扩大不完善
        if (size >= items.length) {
            //扩容 to do 扩大2倍 左移1位
            int[] tempArray = new int[items.length << 1];
            //将之前的元素赋值过来
            items=Arrays.copyOf(items,items.length << 1);
        }
        if (size == 0) {
            min = node;
            minStack.push(min);
        } else {
            if (node < min) {
                min = node;
                minStack.push(min);
            }
        }
        items[size] = node;
        size++;
    }

    public synchronized void pop() {
        if (size == 0) {
            return;
        }
        int now=top();
        size--;
        if(now==min){
            //继续遍历数据找最小数
            if(!minStack.isEmpty()){
                minStack.pop();
            }
            if(!minStack.isEmpty()){
                min=minStack.peek();
            }
        }

    }

    public int top() {
        //返回最上层元素
        if (size == 0) {
            return -1;
        }
        return items[size - 1];
    }

    public int min() {
        if (size == 0) {
            return -1;
        }
        return min;

    }
}
