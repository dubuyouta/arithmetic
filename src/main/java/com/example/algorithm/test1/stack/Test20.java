package com.example.algorithm.test1.stack;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 1:34
 */
public class Test20 {
    /**
     * 题目：
     *    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     *    假设压入栈的所有数字均不相等。
     *   例如序列1,2,3,4,5是某栈的压入顺序，
     *    序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     *    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     */

    public static void main(String[] args) {
        Test20 test = new Test20();
        int[] pushA={1,2,3,4,5,6};
        int[] popA={6,5,4,3,2,9};
        System.out.println(test.isPopOrder(pushA,popA));
    }

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0
                || popA == null || popA.length == 0)
            return false;
        if(pushA.length!=popA.length)
            return false;
        for(int pushIndex=0,popIndex=popA.length-1;
            pushIndex<pushA.length&&popIndex>=0;pushIndex++,popIndex--){
            if(pushA[pushIndex]!=popA[popIndex]){
                return false;
            }
        }
        return true;
    }


}
