package com.example.algorithm.test1.array;

public class Test6 {
    /**
     * 题目：
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */

    public static void main(String[] args) {
        Test6 test=new Test6();
        int[] array={1,0,1,1,1};
        System.out.println(test.minNumberInRotateArray1(array));

    }

    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int pre=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>=pre){
                pre=array[i];
            }else{
                return array[i];
            }
        }
        return array[0];
    }

    //特殊的2分查找法
    public int minNumberInRotateArray1(int [] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            //2分中间值
            int mid = l + (r - l) / 2;
            //低位 小于高位，说明没有倒转，最小值就是低位值
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            //中间值比 后一位大，说明从后一位开始颠倒，返回后一位
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            //中间值比前一位小，说明从中间为，开始颠倒，最小值为中间值
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            //中间值比最初的值大，说明 从 0~mid 依次递增，还未发现颠倒，低位要右移
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                //中间值比0位小或等 说明已经发生颠倒，要继续向左找 更小的颠倒值，高位要左移
                r = mid - 1;
            }
        }
        return 0;
    }
}
