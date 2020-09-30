package com.example.algorithm.test1.number;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/5/15 17:09
 */
public class Test41 {
    /**
     * 输出所有连接正整数和 100 的连续正整数 （连接正整数至少包含2个数）
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * 如： 18,19,20,21,22
     *
     * 此处要求必须连续，一个紧挨一个
     */

    public static void main(String[] args) {
        Test41 test41 = new Test41();
        List<List<Integer>> list = test41.searchNums(100);
        list.forEach(item -> {
            System.out.println(JSON.toJSONString(item));
        });
    }

    /**
     * 思路一： 使用2个指针以移动，中间构成一个区间，查看区间是否满足加起来的值=sum
     *
     * 此处需要使用等差数列去和公式 ： S(n)= (a1+an)*n /  2
     * @param sumTarget
     * @return
     */
    private List<List<Integer>> searchNums(int sumTarget) {
        List<List<Integer>> list = new ArrayList<>();
        int left = 1, right = 2;
        int mid = sumTarget / 2;
        while (left < mid && left < right) {
            int result = (left + right) * (right - left + 1) / 2;
            if (result == sumTarget) {
                List<Integer> integers = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    integers.add(i);
                }
                list.add(integers);
                //如果此次空间满足需求，左指针也右移
                left++;
            } else if (result < sumTarget) {
                //如果区域求和小于目标值，就将空间右指针往右移动
                right++;
            } else {
                //如果空间已经超值，说明整个空间不能达到目前值，空间左指针右移
                left++;
            }
        }
        return list;
    }


}
