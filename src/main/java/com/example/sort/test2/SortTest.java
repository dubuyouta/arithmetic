package com.example.sort.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {
    /**
     * 一共10种排序
     */
    public static void main(String[] args) {
        int[] array = {11, 3, 2, 8, 10, 5, 4, 50, 20, 30};
        SortTest test = new SortTest();
        //System.out.println(JSON.toJSONString(test.bubbleSort(array)));
//        test.quickSort(array,0,array.length-1);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(test.insertSort(array)));
//        System.out.println(Arrays.toString(test.shellSort(array)));
//        System.out.println(Arrays.toString(test.selectSort(array)));
//        System.out.println(Arrays.toString(test.heapSort(array)));
//        System.out.println(Arrays.toString(test.mergeSort(array)));
//        System.out.println(Arrays.toString(test.countSort(array)));
//        System.out.println(Arrays.toString(test.bucketSort(array, 3)));
        System.out.println(Arrays.toString(test.radixSort(array)));
    }

    private int[] bubbleSort(int[] array) {
        if (array == null || array.length <= 0) {
            return array;
        }
        /**
         * 冒泡，经过外层 n-1 次排序; 大的下沉，小的上升
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public void quickSort(int[] array, int start, int end) {
        if (array == null || array.length <= 0 || start >= end) {
            return;
        }
        /**
         * 首先找到一个基准，一般选择其实值，找到基准的位置交换
         * 保证，左边的数 比基准小，右边数比基准大
         */
        int left = start;
        int right = end;
        int temp = array[left];
        while (left < right) {
            //比较右的值
            while (left < right && array[right] >= temp) {
                //右边的数，仍然比基准大，指针往左偏移，还可能有大的值
                right--;
            }
            //跳出循环，此时右指针指向的值array[right]<temp，需要把这个值赋值给左边
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                // 左边的值仍然比基准下，需要右移指针，可能右边还有小的值
                left++;
            }
            //跳出循环，说明左指针指向array[left]>temp,需要交换到右边
            array[right] = array[left];
        }
        System.out.println("left=" + left + " right=" + right);
        //跳出循环，已经找到temp的位置，此时 left=right
        array[left] = temp;
        //分为左右2组递归
        //左递归
        quickSort(array, 0, left - 1);
        //右递归
        quickSort(array, left + 1, end);
    }

    public int[] insertSort(int[] array) {
        //插入排序
        if (array == null || array.length <= 0) {
            return array;
        }
        /**
         * 假设前面的数已经有序，从后选择一个数，从后往前遍历
         * 插入合适的位置，这个位置之后的数后移
         *
         * 在从后向前比较过程中，遇到比基准值大的数，统统后移
         */
        for (int i = 1; i < array.length; i++) {
            //待比较值
            int temp = array[i];
            int j = i;
            for (; j - 1 >= 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            if (j != i) {
                array[j] = temp;
            }
        }
        //另一种写法
//        for(int i=1;i<array.length;i++){
//            //待比较值
//            int temp=array[i];
//            for(int j=i;j>=0;j--){
//                if(j>0&&array[j-1]>temp) {
//                    array[j] = array[j - 1];
//                }else{
//                    array[j]=temp;
//                    break;
//                }
//            }
//        }
        return array;
    }

    public int[] shellSort(int[] array) {
        //插入排序的变种版
        if (array == null || array.length <= 0) {
            return array;
        }
        /**
         * 使用一个步长，一步步插入排序，
         * 直到步长为1，等于插入，排序有序
         */
//        int gap=array.length/2;
//        while (gap>0){
//            for(int i=gap;i<array.length;i+=gap){
//                int temp=array[i];
//                int j=i;
//                for(;j-gap>=0&&array[j-gap]>temp;j-=gap){
//                    array[j]=array[j-gap];
//                }
//                if(j!=i){
//                    array[j]=temp;
//                }
//            }
//            gap/=2;
//        }
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                int j = i;
                for (; j - gap >= 0 && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                if (j != i) {
                    array[j] = temp;
                }
            }
        }
        return array;

    }

    public int[] selectSort(int[] array) {
        /**
         * 选择排序，选择最小排第一位，然后依次排下去
         */
        if (array == null || array.length <= 0) {
            return array;
        }
        /**
         * 选择排序，是选择最小排序的 下标，
         * 再获取最小的元素和当前元素进行交换
         */
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;

    }

    public int[] heapSort(int[] array) {
        /**
         * 前面 n-1 个数 构建最大堆，
         * 然后第一个元素 和 第n个元素交换
         */
        if (array == null || array.length <= 0) {
            return array;
        }
        for (int heapLength = array.length; heapLength > 0; heapLength--) {
            buildMaxHeap(array, heapLength);
            //交换
            int temp = array[0];
            array[0] = array[heapLength - 1];
            array[heapLength - 1] = temp;
        }
        return array;
    }

    private void buildMaxHeap(int[] array, int heapLength) {
        /**
         * array[k]>=array[2k]
         * array[k]>=array[2k+1]
         * 记录每一次 3个数最小的index
         * 首先构建最大堆，循环 堆heapLength的一般大小
         * 从一半开始，从后往前循环
         */
        for (int i = heapLength / 2; i >= 0; i--) {
            int min = i;
            if (2 * i < heapLength && array[min] < array[2 * i]) {
                min = 2 * i;
            }
            if (2 * i + 1 < heapLength && array[min] < array[2 * i + 1]) {
                min = 2 * i + 1;
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public int[] mergeSort(int[] array) {
        /**
         * 归并排序，从中间分开2个数组，再分别递归归并，
         * 直到数据size为 1 ，再逐渐合并数据
         */
        if (array == null || array.length < 2) {
            return array;
        }
        int half = array.length / 2;
        //需要多余左右空间
        int[] left = Arrays.copyOfRange(array, 0, half);
        int[] right = Arrays.copyOfRange(array, half, array.length);
        return mergeTowArray(mergeSort(left), mergeSort(right));
    }

    private int[] mergeTowArray(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];
        //合并2个数组，都是有序数组
//        int index=0;
//        int l=0,r=0;
//        while (index<array.length){
//            if(l>=left.length){
//                array[index]=right[r];
//                index++;
//                r++;
//            }else if(r>=right.length){
//                array[index]=left[l];
//                index++;
//                l++;
//            }else if(left[l]<right[r]){
//                array[index]=left[l];
//                index++;
//                l++;
//            }else{
//                array[index]=right[r];
//                index++;
//                r++;
//            }
//        }
        for (int index = 0, l = 0, r = 0; index < array.length; index++) {
            if (l >= left.length) {
                array[index] = right[r++];
            } else if (r >= right.length) {
                array[index] = left[l++];
            } else if (left[l] < right[r]) {
                array[index] = left[l++];
            } else {
                array[index] = right[r++];
            }
        }
        return array;
    }

    public int[] countSort(int[] array) {
        /**
         * 计数排序，桶内记录相同元素的个数
         * 要求 min-max 正整数
         */
        if (array == null || array.length <= 0) {
            return array;
        }
        //先找到最大 最小数
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        //计算差值，桶的长度
        int bucketLength = max - min + 1;
        //将数据加入桶内，开始计数
        int[] bucketArray = new int[bucketLength];
        //初始化数据0
        Arrays.fill(bucketArray, 0);
        for (int i = 0; i < array.length; i++) {
            //错误处
            // int bucketIndex=max-min;
            int bucketIndex = array[i] - min;
            bucketArray[bucketIndex]++;
        }
        //所有数据桶内计数了，再桶的数据依次拼接有序序列
        //桶下标有序
        int arrayIndex = 0;
        for (int i = 0; i < bucketArray.length; i++) {
            while (bucketArray[i] > 0) {
                int arrayData = min + i;
                array[arrayIndex] = arrayData;
                //桶的计数减1
                bucketArray[i]--;
                arrayIndex++;
            }
        }
        return array;

    }

    public int[] bucketSort(int[] array, int bucketSize) {
        /**
         * 参数 原数组 和 每个桶 所放数据容量
         */
        if (array == null || array.length <= 0 || bucketSize < 1) {
            return array;
        }
        /**
         * 计算需要多少桶，然后将桶的数据按求余放入桶内
         * 然后，减小桶的大小，直到为1，
         * 再将桶的数据拼接起来
         */
        //找到最大 最小
        //先找到最大 最小数
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        //计算差值，桶的长度
        int bucketLength = (max - min) / bucketSize + 1;
        List<List<Integer>> bucketList = new ArrayList<>(bucketLength);
        //初始化桶
        for (int i = 0; i < bucketLength; i++) {
            bucketList.add(new ArrayList<>(bucketSize));
        }
        //将数据统计放入桶内
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / bucketSize;
            bucketList.get(index).add(array[i]);
        }
        //将桶内size不为1，继续拆分
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < bucketList.size(); i++) {
            if (bucketSize == 1) {
                //将数据按顺序叠加桶内
                resultList.addAll(bucketList.get(i));
            } else {
                int[] tempArray = bucketSort(bucketList.get(i).stream().mapToInt(Integer::intValue).toArray(),
                        bucketSize - 1);
                resultList.addAll(Arrays.stream(tempArray).boxed().collect(Collectors.toList()));
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] radixSort(int[] array) {
        /**
         * 基数排序，先排个位，再排10位，百位，就有序
         */
        if (array == null || array.length <= 0) {
            return array;
        }
        //先找到最大数，计算其位数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxNums = 0;
        while (max > 0) {
            max /= 10;
            maxNums++;
        }
        //10个桶
        List<List<Integer>> bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        //将数据循环maxNums 放入桶内
        for (int i = 0, mod = 10, div = 1; i < maxNums; i++, mod *= 10, div *= 10) {
            //计算个位 十位 百位
            for (int j = 0; j < array.length; j++) {
                int index = array[j] % mod / div;
                bucketList.get(index).add(array[j]);
            }
            // 一个 位循环一遍，然后就把桶数据拼接起来
            int arrayIndex = 0;
            for (int x = 0; x < bucketList.size(); x++) {
                for (int j = 0; j < bucketList.get(x).size(); j++) {
                    array[arrayIndex] = bucketList.get(x).get(j);
                    arrayIndex++;
                }
                //赋值完后，清除每个桶现在的数据
                bucketList.get(x).clear();
            }
        }
        return array;
    }
}
