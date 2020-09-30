package com.example.algorithm.test2.queue;

import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 11:44
 */
public class Test5 {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */

    public static void main(String[] args) {
        Test5 test5=new Test5();

        test5.push(1);
        test5.push(2);
        test5.push(3);
        test5.push(4);
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        test5.push(5);
        test5.push(6);
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        System.out.println(test5.pop());



    }

    private Stack<Integer> stackPush=new Stack<>();

    private Stack<Integer> stackPop=new Stack<>();

    //入队
    private void push(int val){
        stackPush.push(val);
    }

    //出队
    private int pop(){
        if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        if(!stackPop.isEmpty()){
            return stackPop.pop();
        }
        return -1;
    }

}
