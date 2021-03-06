package com.example.algorithm.test1.array;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 15:08
 */
public class Test27 {

    /**
     * 题目：
     *   数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *   例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
     *   超过数组长度的一半，因此输出2。如果不存在则输出0
     *
     *   可以使用 异或来判断 是否有重复数 a^a=0  2个数只有相同才能0
     */

    public static void main(String[] args) {
        Test27 test =new Test27();
        int[] array={1,2,3,2,2,2,5,4,2};
        System.out.println(test.moreThanHalfNumSolution(array));
    }

    /**
     *
     * 用preValue记录上一次访问的值，count表明当前值出现的次数，
     * 如果下一个值和当前值相同那么count++；如果不同count--，
     * 减到0的时候就要更换新的preValue值了，因为如果存在超过数组长度一半的值，
     * 那么最后preValue一定会是该值
     * @param array
     * @return
     */
    public int moreThanHalfNumSolution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int preValue = array[0];//用来记录上一次的记录
        int count = 1;//preValue出现的次数（相减之后）
        for(int i = 1; i < array.length; i++){
            if(array[i] == preValue)
                count++;
            else{
                count--;
                if(count == 0){
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;//需要判断是否真的是大于1半数
        for(int i=0; i < array.length; i++) {
            if (array[i] == preValue) {
                num++;
            }
        }
        return (num > array.length/2)?preValue:0;

    }
}
