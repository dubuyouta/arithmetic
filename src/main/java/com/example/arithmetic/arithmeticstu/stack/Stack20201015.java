package com.example.arithmetic.arithmeticstu.stack;

import java.util.Stack;

/**
 * 通过栈实现队列
 * 1.队列：先进先出
 * 2.栈：后进先出
 *
 * @author xiaobao.chen
 * Create at 2020/10/15
 */
public class Stack20201015 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(5);
        myQueue.push(6);
        myQueue.push(7);
        myQueue.push(8);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    public static class MyQueue {

        private Stack<Integer> stack1;

        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
