package com.example.arithmetic.arithmeticstu.base;

/**
 * 计数排序：利用额外的空间存储数组元素出现的次数。
 * 步骤：
 * 1.找出最大值和最小值
 * 2.根据最大值和最小值，构建新数组的长度。（max-min+1）
 * 3.利用原数组数据 - 最小值 = 新数组的下标
 * 4.新数组的下标元素对应的值是出现的次数    ---第三步和第四步很巧妙。 通过数组下标进行了排序。
 * 5.根据新数组数据，输出对应的元素。 元素的值=新数组下标+min(第三步的反向使用。)
 *
 * @author xiaobao.chen
 * Create at 2020-06-23
 */
public class CountSort {

    public int[] countSort(int[] a) {
        int max = 0, min = 0;
        //找到最大值和最小值
        for (int temp : a) {
            if (temp > max) {
                max = temp;
            }
            if (temp < min) {
                min = temp;
            }
        }

        //新数组
        int[] b = new int[max - min + 1];
        //通过减法。和 数组下标进行排序
        for (int temp : a) {
            b[temp - min] += 1;
        }

        //根据新数组，找到排序后的数组
        int[] newa = new int[a.length];
        int index = 0, i = 0;
        while (index < b.length) {
            if (b[index] > 0) {
                newa[i] = index + min;
                i++;
                b[index]--;
            } else {
                index++;
            }
        }
        return newa;
    }
}
