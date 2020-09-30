package com.example.algorithm.test1;

/**
 * @author: heshineng
 * @createdBy: 2019/11/28 14:05
 */
public class Test32 {
    /**
     * 题目：
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
     * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
     * 求按从小到大的顺序的第N个丑数。
     *
     * 解题思路：
     * 一个丑数 可以分解 2^x*3^y*5^z  一个新的丑数 也只能 乘以 上一个丑数 乘以 2 3 5 得到
     */

    /**

     * 首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，
     * 换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，
     * 就得到2,3,5三个丑数，在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，
     * 我们发现这种方***得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。
     * 那么我们可以维护三个队列：
     *
     * （1）丑数数组： 1
     * 乘以2的队列：2
     * 乘以3的队列：3
     * 乘以5的队列：5
     * 选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （2）丑数数组：1,2
     * 乘以2的队列：4
     * 乘以3的队列：3，6
     * 乘以5的队列：5，10
     * 选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （3）丑数数组：1,2,3
     * 乘以2的队列：4,6
     * 乘以3的队列：6,9
     * 乘以5的队列：5,10,15
     * 选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （4）丑数数组：1,2,3,4
     * 乘以2的队列：6，8
     * 乘以3的队列：6,9,12
     * 乘以5的队列：5,10,15,20
     * 选择三个队列头里最小的数5加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （5）丑数数组：1,2,3,4,5
     * 乘以2的队列：6,8,10，
     * 乘以3的队列：6,9,12,15
     * 乘以5的队列：10,15,20,25
     * 选择三个队列头里最小的数6加入丑数数组，但我们发现，有两个队列头都为6，所以我们弹出两个队列头，同时将12,18,30放入三个队列；
     * @param args
     */

    public static void main(String[] args) {
        Test32 test32=new Test32();
        System.out.println(test32.getUglyNumber1(5));

    }

    public int getUglyNumber1(int index) {
        if(index<=0){
         return 0;
        }
        int[] array=new int[index];
        array[0]=1;
        int p2=0,p3=0,p5=0;
        //每次使用 array的当前值去循环 乘以 2 3 5
        for(int i=1;i<index;i++){
            array[i] = Math.min(array[p2]*2, Math.min(array[p3]*3, array[p5]*5));
            //为了防止当前位 假如与 p2 p3 p5 从头到尾的一个乘积
            /**
             * p2 p3 p5 都是从0 开始的
             * 就是为了验证 每次得到的最小值，是否和已经的值重复
             * 3个指针从0开始，当前值谁根 原数原数重复，哪个指针就 -》 移动加 1
             */
            if(array[i] == array[p2]*2){
                p2++;
            }
            if(array[i] == array[p3]*3){
                p3++;
            }
            if(array[i] == array[p5]*5){
                p5++;
            }
        }
        return array[index-1];
    }
}
