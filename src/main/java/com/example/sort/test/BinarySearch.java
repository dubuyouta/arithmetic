package com.example.sort.test;

public class BinarySearch {
    /**
     *也称折半搜索，是一种在 有序数组 中 查找某一特定元素 的搜索算法。
     * 搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，
     * 则搜索过程结束；
     *     1.如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，
     *     而且跟开始一样从中间元素开始比较。
     *     2.如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。
     *
     *     时间复杂度:折半搜索每次把搜索区域减少一半，时间复杂度为O(log n)。（n代表集合中元素的个数）
     *     空间复杂度： O(1)。虽以递归形式定义，但是尾递归，可改写为循环。
     *
     *
     *    优缺点：
     *  二分查找法的O(log n)让它成为十分高效的算法。不过它的缺陷却也是那么明显的。
     *  就在它的限定之上：必须有序，我们很难保证我们的数组都是有序的。
     *  当然可以在构建数组的时候进行排序，可是又落到了第二个瓶颈上：它必须是数组。
     *
     *   数组读取效率是O(1)，可是它的插入和删除某个元素的效率却是O(n)。因而导致构建有序数组变成低效的事情。
     *
     *    解决这些缺陷问题更好的方法应该是使用二叉查找树了，最好自然是自平衡二叉查找树了，
     *    既能高效的（O(n log n)）构建有序元素集合，又能如同二分查找法一样快速（O(log n)）的搜寻目标数。
     *
     *    如何计算二分查找中的中值？
     *    算法一： mid = (low + high) / 2
     *    算法二： mid = low + (high – low)/2  推荐（不存在 low+high 大于 int最大值2 的32次减1 ，之后的溢出成为负值）
     *
     *    看起来，算法一简洁，算法二提取之后，跟算法一没有什么区别。但是实际上，区别是存在的。算法一的做法，
     *    在极端情况下，(low + high)存在着溢出的风险，进而得到错误的mid结果，
     *    导致程序错误。而算法二能够保证计算出来的mid，一定大于low，小于high，不存在溢出的问题
     */
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] array = {1, 5, 8, 10, 11, 15, 19, 21, 24, 30, 40};
        System.out.println(search.binarySearch1(array, 9));
        //System.out.println(search.binarySearch2(array, 7, 0, array.length - 1));
    }

    /**
     * 循环实现
     */
    private int binarySearch1(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid  = left + (right - left) / 2;
        //此处为<=
        while (left <= right) {
            if (array[mid] > target) {
                /**
                 * 向低位找 此处一定要加1位，要不然当找不到数组时，
                 * 不能跳出left < right 这个条件永远成立，就出现死循环
                 * 减一位就是找不到时跳出循环
                 */
                right = mid - 1;
            } else if (array[mid] < target) {
                /**
                 * 向高位找
                 * 加1，往前进一位，防止找不到时出现死循环情况
                 */
                left = mid + 1;
            } else {
                //找到
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        System.out.println(mid);
        return -1;

    }

    /**
     * 递归实现
     */
    private int binarySearch2(int[] array, int target, int low, int high) {
        if (array == null || array.length == 0 || low >= high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] > target) {
            //向左找
            return binarySearch2(array, target, low, mid - 1);
        } else if (array[mid] < target) {
            //向右找
            return binarySearch2(array, target, mid + 1, high);
        } else {
            return mid;
        }
    }
}
