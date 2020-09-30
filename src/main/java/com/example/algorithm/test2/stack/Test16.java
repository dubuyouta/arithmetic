package com.example.algorithm.test2.stack;

import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2020/7/27 14:26
 */
public class Test16 {
    /**
     * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，
     * 但不得将元素复制到别的数据结构中。
     *
     * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
     * 请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
     * 测试样例：
     * [1,2,3,4,5]
     * 返回：[5,4,3,2,1]
     */

    public static void main(String[] args) {
        Test16 test16=new Test16();
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(6);

        Stack<Integer> result=test16.sortStack(stack);
        while (!result.isEmpty()){
            System.out.println(result.pop());
        }
    }

    /**
     * 需要对原始栈排序，当临时栈为空，事，将原始栈栈顶数据出栈放入临时栈中
     * 需要假设临时栈是排好的序列，（类比插入排序）
     * 当原始栈栈顶出栈数，需要将临时栈的数据依次出栈放入原始栈，
     * 然后将原始栈的数据放入合适的位置
     * 3
     * 1
     * 4
     * 5
     * 2
     * 6
     *
     * 1  3         先将1暂存 ，然后3入原始栈   3     1
     * 4                                       4
     * 5                                       5
     * 2                                       2
     * 6                                       6
     * @param stack
     * @return
     */
    private Stack<Integer> sortStack(Stack<Integer> stack){
        if(stack==null||stack.isEmpty()){
            return stack;
        }
        //只能使用一个临时栈,假设临时栈已排好序，将原始栈的数据插入临时栈合适的位置
        //当原始栈的数据为空，临时栈就是需要返回的数据
        Stack<Integer> tempStack=new Stack<>();
        while (!stack.isEmpty()){
            int popTemp=stack.pop();
            while (!tempStack.isEmpty()&&tempStack.peek()>popTemp){
                stack.push(tempStack.pop());
            }
            tempStack.push(popTemp);
        }
        return tempStack;
    }
}
