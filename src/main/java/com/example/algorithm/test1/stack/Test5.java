package com.example.algorithm.test1.stack;

import java.util.Stack;

public class Test5 {
    /**
     * 题目描述
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     *
     * 分析 栈的特性是 后进先出  队列的特性是新进新出
     *
     * push 是入队 pop是出队  要求实现队列特性
     *
     * 在添加元素时，一个栈入栈 一个栈出栈
     */

    public static void main(String[] args) {
        Test5 test=new Test5();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);

        for(int i=0;i<6;i++){
            System.out.println(test.pop());
        }

    }

    //当入栈的池
    Stack<Integer> stack1 = new Stack<Integer>();
    //当出栈池
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

//    public int pop() {
//        while (!stack1.empty()){
//            stack2.push(stack1.pop());
//        }
//        return stack2.pop();
//    }

    /**
     * 主要就是利用2个栈的颠倒，但是需要处理优化一下
     * @return
     */
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
