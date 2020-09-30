package com.example.sort.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortTest {
    /**
     * 基数排序
     * 是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
     * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数
     * <p>
     * 比较思想
     * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列
     * <p>
     * MSD（Most significant digital） 从最左侧高位开始进行排序。先按k1排序分组, 同一组中记录, 关键码k1相等,
     * 再对各组按k2排序分成子组, 之后, 对后面的关键码继续这样的排序分组,
     * 直到按最次位关键码kd对各子组排序后. 再将各组连接起来, 便得到一个有序序列。MSD方式适用于位数多的序列。
     * <p>
     * <p>
     * LSD （Least significant digital）从最右侧低位开始进行排序。
     * 先从kd开始排序，再对kd-1进行排序，依次重复，直到对k1排序后便得到一个有序序列。LSD方式适用于位数少的序列。
     */

    public static void main(String[] args) {
        RadixSortTest test = new RadixSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.radixSort(array)));
    }

    /**
     * 1.取得数组中最大数，并获取其位数
     * 2.找到最大数，一共有n位数
     * 3.如n=3，则最大数有 个 十 百 3位数，则需要分别对
     * 从低位开始，遍历 个位 十位 百位
     * <p>
     * 3遍遍历 是先从个位遍历，按个位相同数放在同一个桶内
     * 再把桶内数串联起来得到一个数列
     * <p>
     * 再把上面等到数列，按10位相同，放在10个桶内，再把数据
     * 依次串联，得到新数列
     * <p>
     * 百位依然重复上面
     * <p>
     * 最后得到数列就是顺序
     * <p>
     * 如 73  22  93  43  55  14  28  65  39  81
     * <p>
     * 个位排序
     *    0   1    2    3    4    5    6     7     8      9
     *       81   22   73   14   55               28     39
     *                 93        65
     *                 43
     * <p>
     * 得到新数列：81,22,73,93,43,14,55,65,28,39
     * <p>
     * 十位排序
     *     0   1    2    3    4    5    6     7     8      9
     *         14   22   39   43   55   65    73    81     93
     *              28
     * <p>
     * 得到新数列：14,22,28,39,43,55,65,73,81,93
     * <p>
     * 总结；首先排个位数，将个位一样的数据放在一个桶内 桶 0-9
     * 依次拼接 得到数列 C1；
     * <p>
     * 在数列C1的基础上，
     * 再按个位一样的数，放在同一个桶内，
     * 依次拼接 得到数列 C2；
     * <p>
     * 得到的新数列就是有序数列
     *
     *
     * 时间复杂度 最好=O(n * k)  平均=O(n * k) 最差=O(n * k)
     * 空间复杂度 O(n+k)
     * 稳定排序
     *
     * @param array
     * @return
     */
    public int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int max = array[0];
        //找出最大数
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //计算最大数的位数
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        List<List<Integer>> bucketList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        /**
         * 从右向左，从低位排序开始
         * 需要重复 10倍 100倍
         */
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                /**
                 * 此方法计算原数组 元素数据的每一位
                 * 如 467， 467%10/1，先对10 求余，算出最后一位，对1求商，算出 本身 7
                 *          467%100/10 求余100，得到最后2位 67，对10求商，得出第二位数 6
                 */
                //分别求出 个位 十位 百位 。。。
                int num = (array[j] % mod) / div;
                //将相同位 的相同数 装在同一个桶内
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            //将所有桶内数据拼接再一起
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index] = bucketList.get(j).get(k);
                    index++;
                }
                bucketList.get(j).clear();
            }
        }
        return array;


    }

    public static void radixSort1(int[] arr) {
        if (arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }

        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }

            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }
}
