package com.example.algorithm.test1.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/5/15 15:17
 */
public class Test40 {

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
     *
     * 按 异或 运算符处理： (二进制位 相同位异或为0，不同位异或为 1)
     * A^A=0 0^A=A
     *
     * 在一个简单的方法使用map 记录 key 和 value关系
     */

    public static void main(String[] args) {
        Test40 test40=new Test40();
        int[] array={1,1,2,2,3,3,4,5,5};
        System.out.println(test40.getNum1(array));
    }

    private int getNum(int[] array){
        if(array==null||array.length==0){
            return -1;
        }
        int result=array[0];
        for(int i=1;i<array.length;i++){
            result=result^array[i];
        }
        return result;
    }

    //使用list，不存在元素就添加，存在就删除
    private int getNum1(int[] array){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(list.contains(array[i])){
                /**
                 * 直接使用使用remove（int）
                 * 会默认调用 remove(int index)
                 * 按索引位置删除数据
                 */
                //list.remove(array[i]);
                list.remove(new Integer(array[i]));
            }else{
                list.add(array[i]);
            }
        }
        return list.get(0);


    }


}
