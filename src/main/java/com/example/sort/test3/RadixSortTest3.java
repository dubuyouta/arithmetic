package com.example.sort.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortTest3 {

    public static void main(String[] args) {
        RadixSortTest3 test=new RadixSortTest3();
        //int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        int[] array = {10,6,9,30,100,97,40,50};
        System.out.println(Arrays.toString(test.test(array)));
    }

    /**
     * 基数排序 就是 比较 先按 个位排序 再按十位 排序 最后按排序。。
     * 最后最高位排好序，所有数据有序
     *
     * 做法 先找到最大一个数，确定是几位数
     * 然后 个位相同数，放入一个桶
     * 然后 按顺序 10排序放一个桶
     * 最后 百位顺序 放一个桶
     * 数据连接
     *
     * 每次10个桶？ 每个桶的大小无限
     *  {10,6,9,30,100,97,40,50}
     *  个位
     *  0 10 30 100 40 50
     *  6 6
     *  7 97
     *
     *  十位
     *  0 100 6
     *  1 10
     *  3 30
     *  4 40
     *  5 50
     *  9 97
     *
     *  百位
     *  0 6 10 30 40 50 97
     *  1 100
     *
     * 所以排完 6,10,30,40,50,97,100
     *
     * 注意：每一次排序依赖上一次的桶排序结果，必须从编号0的桶的数据开始遍历
     * 如 十位排序 利用 个位 桶已排好顺序，而且必须将每个桶的数据排完才能开始下一个桶
     */
    private int[] test(int[] array){
        if(array==null||array.length<2){
            return array;
        }
        int max=array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        //计算最大数的位数
        int nums=0;
        while (max>0){
            nums++;
            max/=10;
        }
        //一共位数需要比较 nums 次
        /**
         * 先比较 个位 再比较 十位 最后比较 百位
         * 每次位数排序完，组合成原数组，便于下面的循环
         */
        List<List<Integer>> bucketList=new ArrayList<>(10);
        for(int i=0;i<10;i++){
            bucketList.add(new ArrayList<>());
        }
        int div=1;
        for(int numIndex=0;numIndex<nums;numIndex++){
            for(int i=0;i<array.length;i++){
                //numIndex=0 个位
                /**
                 * 此处应该有问题
                 * 先求余 再除数 并且 2这都是以10阶乘的
                 * int mod=10，div=1；
                 *
                 * 先除 再一直以10求余也可
                 */
                int index=array[i]/(div)%10;
                bucketList.get(index).add(array[i]);
            }
            //将桶数组赋值到原数组中，便于下次循环，并且清除桶内元素
            int index=0;
            for(int bucketIndex=0;bucketIndex<bucketList.size();bucketIndex++){
                if(bucketList.get(bucketIndex).size()==0){
                    continue;
                }
                for(int j=0;j<bucketList.get(bucketIndex).size();j++){
                    array[index]=bucketList.get(bucketIndex).get(j);
                    index++;
                }
                bucketList.get(bucketIndex).clear();
            }
            div*=10;
        }
        return array;
    }
}
