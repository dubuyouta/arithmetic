package com.example.algorithm.test2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class SortAllTemplateTest1 {

    /**
     * 所有排序的模板，基于这个模板，写新的排序
     * 所有的排序算法，自己写会，并且，知道时间复杂度
     * 和空间复杂度，以及稳定性
     */
    public static void main(String[] args) {
        SortAllTemplateTest1 allTest = new SortAllTemplateTest1();

        int[] array1 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.bubbleSort(array1);
        System.out.println("冒泡：" + Arrays.toString(array1));

        int[] array2 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.quickSort(array2, 0, array2.length - 1);
        System.out.println("快排：" + Arrays.toString(array2));

        int[] array3 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.insertSort(array3);
        System.out.println("插入：" + Arrays.toString(array3));

        int[] array4 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.shellSort(array4);
        System.out.println("希尔：" + Arrays.toString(array4));

        int[] array5 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.selectSort(array5);
        System.out.println("选择：" + Arrays.toString(array5));

        int[] array6 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.heapSort(array6);
        System.out.println("堆：" + Arrays.toString(array6));

        int[] array7 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array7 = allTest.mergeSort(array7);
        System.out.println("归并：" + Arrays.toString(array7));

        int[] array8 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array8 = allTest.countSort(array8);
        System.out.println("计数：" + Arrays.toString(array8));

        int[] array9 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array9 = allTest.bucketSort(array9, 4);
        System.out.println("桶：" + Arrays.toString(array9));

        int[] array10 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array10 = allTest.radixSort(array10);
        System.out.println("基数：" + Arrays.toString(array10));

        int[] array11 = {1, 2, 3, 7, 7, 7, 8, 9, 10, 15};
        int index11 = allTest.binarySearch(array11, 8);
        System.out.println("二分：" + index11);

        int[] array12 = {1, 2, 3, 7, 7, 7, 8, 9, 10, 15};
        int index12 = allTest.binarySearchFirst(array12, 7);
        System.out.println("二分第一个：" + index12);

        int[] array13 = {1, 2, 3, 7, 7, 7, 8, 9, 10, 15};
        int index13 = allTest.binarySearchLast(array13, 7);
        System.out.println("二分最后一个：" + index13);

    }

    /**
     * 交换排序
     *
     * 冒泡排序
     * 稳定排序
     * 时间 平均 O(n^2) 最差O(n^2) 最好O(n)
     * 空间 O(1)
     */
    public void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    /**
     *  交换排序
     *
     *  快速排序
     * 不稳定排序
     * 时间 平均 O(logn) 最差O(n^2) 最好O(logn)
     * 空间 O(1)
     */
    public void quickSort(int[] array, int low, int high) {
        if (array == null || array.length < 2
                || low < 0 || high >= array.length
                || low > high) {
            return;
        }
        //此处切记为 low
        //int left = 0;
        int left = low;
        //此处写错，切记为high
        //int right = array.length - 1;
        int right = high;
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        quickSort(array, low, left - 1);
        quickSort(array, left + 1, high);
    }

    /**
     *  插入排序
     *
     *  直接快速排序
     *  稳定排序
     * 时间 平均 O(n^2) 最差O(n^2) 最好O(n)
     * 空间 O(1)
     */
    public void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j - 1] > temp) {
                    array[j] = array[j - 1];
                } else {
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     *  插入排序
     *
     *  希尔排序
     *  不稳定排序
     * 时间 平均 O(n^1.3) 最差O(n^2) 最好O(logn)
     * 空间 O(1)
     */
    public void shellSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //for (int i = gap; i < array.length; i++) {
            //此处切记为 加 gap
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                //此处为 int j=i;
                //for (int j = gap; j >= 0; j -= gap) {
                for (int j = i; j >= 0; j -= gap) {
                    if (j >= gap && array[j - gap] > temp) {
                        array[j] = array[j - gap];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     *  选择排序
     *
     *  希尔排序
     *  不稳定排序
     * 时间 平均 O(n^2) 最差O(n^2) 最好O(n^2)
     * 空间 O(1)  选择一次可以选择最大最小2个数
     */
    public void selectSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }

    /**
     *  选择排序
     *
     *  堆排序
     *  不稳定排序
     * 时间 平均 O(logn) 最差O(logn) 最好O(logn)
     * 空间 O(1)
     */
    public void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int heapSize = array.length; heapSize > 0; heapSize--) {
            for (int i = heapSize / 2; i >= 0; i--) {
                int left = 2 * i >= heapSize ? heapSize - 1 : i * 2;
                int right = 2 * i + 1 >= heapSize ? left : i * 2 + 1;
                int maxIndex = array[left] >= array[right] ? left : right;
                //切记，此处交换判断，将小的换到后面，大的放到前面
                //if (array[i] > array[maxIndex]) {
                if (array[maxIndex] > array[i]) {
                    int temp = array[i];
                    array[i] = array[maxIndex];
                    array[maxIndex] = temp;
                }
            }
            int temp = array[0];
            array[0] = array[heapSize - 1];
            array[heapSize - 1] = temp;
        }

    }

    /**
     *  归并排序
     *
     *  二路排序
     *  稳定排序
     * 时间 平均 O(logn) 最差O(logn) 最好O(logn)
     * 空间 O(n)
     */
    public int[] mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int half = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, half));
        int[] right = mergeSort(Arrays.copyOfRange(array, half, array.length));
        return mergeTowArray(left, right);
    }

    public int[] mergeTowArray(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];
        int index = 0, l = 0, r = 0;
        while (index < array.length) {
            if (l >= left.length) {
                array[index++] = right[r++];
                //continue;
            } else if (r >= right.length) {
                array[index++] = left[l++];
            } else if (left[l] <= right[r]) {
                array[index++] = left[l++];
            } else {
                array[index++] = right[r++];
            }
        }
        return array;
    }

    /**
     *  非线性
     *
     *  计数
     *  稳定排序
     * 时间 平均 O(n) 最差O(n) 最好O(n)
     * 空间 O(k)
     */
    public int[] countSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int bucketSize = max - min + 1;
        int[] bucketArray = new int[bucketSize];
        for (int i = 0; i < array.length; i++) {
            bucketArray[array[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < bucketSize; i++) {
            if (bucketArray[i] > 0) {
                for (int j = 0; j < bucketArray[i]; j++) {
                    array[index++] = i + min;
                }
            }
        }
        return array;
    }

    /**
     *  非线性
     *
     *  桶排序
     *  稳定排序
     * 时间 平均 O(n) 最差O(n) 最好O(n^2)
     * 空间 O(n+k)
     */
    public int[] bucketSort(int[] array, int capacity) {
        if (array == null || array.length < 2 || capacity < 1) {
            return array;
        }
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int size = (max - min) / capacity + 1;
        List<List<Integer>> bucketList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            bucketList.add(new ArrayList<>(capacity));
        }
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / capacity;
            bucketList.get(index).add(array[i]);
        }
        //合并结果
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> tempList = bucketList.get(i);
            if (!tempList.isEmpty()) {
                int[] tempArray = bucketSort(tempList.stream().mapToInt(Integer::valueOf).toArray(), capacity - 1);
                result.addAll(Arrays.stream(tempArray).boxed().collect(Collectors.toList()));
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     *  非线性
     *
     *  基数
     *  稳定排序
     * 时间 平均 O(n) 最差O(n) 最好O(n)
     * 空间 O(n+k)
     */
    public int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int num = 0;
        while (max > 0) {
            num++;
            //此处为max
            //num /= 10;
            max /= 10;
        }
        int bucketSize = 10;
        List<List<Integer>> bucketList = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(new ArrayList<>(array.length));
        }
        for (int i = 0, mod = 10, div = 1; i < num; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int index = array[j] % mod / div;
                bucketList.get(index).add(array[j]);
            }
            //将数据组合成数组
            int index = 0;
            for (int j = 0; j < bucketSize; j++) {
                List<Integer> tempList = bucketList.get(j);
                for (int k = 0; k < tempList.size(); k++) {
                    array[index++] = tempList.get(k);
                }
                bucketList.get(j).clear();
            }
        }

        return array;

    }

    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array[0] > target || array[array.length - 1] < target) {
            return -1;
        }
        int low = 0, high = array.length - 1;
        int mid = low + (high - low) / 2;
        //切记，此处为<=
        while (low <= high) {
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
            mid = low + (high - low) / 2;
        }
        return -1;
    }

    public int binarySearchFirst(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array[0] > target || array[array.length - 1] < target) {
            return -1;
        }
        //<=
        int low = 0, high = array.length - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            //写错 此处应该只是小于
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return low;
    }

    public int binarySearchLast(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array[0] > target || array[array.length - 1] < target) {
            return -1;
        }
        int low = 0, high = array.length - 1;
        int mid = low + (high - low) / 2;
        //切记，此处为<=
        while (low <= high) {
            if (array[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return high;
    }


}
