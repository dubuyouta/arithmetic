package com.example.algorithm.test1.matrix;

public class Test1 {
    /**
     * 题目：
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 自己分析：此2维数组是一个有序数列，可以使用2分查找法，
     * 分别进行行列2分
     *
     * 关于二维数组详解：
     * 首先对于 int[][] array=new int[m][n];
     *          array 是一个 m列 n行的二维数组
     *          其中 m---> 列=col ---> 左右移动方式 代表矩阵的横向方式
     *             n --> 行=row ---> 上下移动方式 代表矩阵的纵向方式
     *          m代表二维数组有多少一位数组，n代表每个一位数组有多少列
     *
     *          int[][] array=new int[m][n] 是由原来的一维数组
     *          int[] arrays=new int[m] 纵向生长变化而来
     *
     *           1 2 3
     *           4 5 6
     *           7 8 9
     *          对于数组int[][] array=new int[3][3]
     *          array[2][0]=3  代表第2列，第0行数字
     *          array[0][2]=7  代表第0列，第2行数字
     *          数组定义的方式 int[][] array={{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}
     *           每一个小数组代表1列数据
     *
     *           或者
     *         array[0] = new int[]{1, 4, 7};
     *         array[1] = new int[]{2, 5, 8};
     *         array[2] = new int[]{3, 6, 9};
     */
    public static void main(String[] args) {
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        int[][] arraytest = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        for (int r = 0; r < arraytest[0].length; r++) {
            for (int c = 0; c < arraytest.length; c++) {
                System.out.println("m=" + c + " n=" + r + " " + arraytest[c][r]);
            }
        }

        Test1 test = new Test1();
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 20, 25, 26};
        array[1] = new int[]{10, 21, 26, 27};
        array[2] = new int[]{20, 23, 30, 31};
        array[3] = new int[]{30, 31, 35, 36};
        /**
         *  1  10  20  30
         * 20  21  23  31
         * 25  26  30  35
         * 26  27  31  36
         */
        System.out.println(test.find5(28, array));
    }

    /**
     * 暴力破解模式
     * 直接2遍循环处理，如果实在不会时使用
     * <p>
     * 比较low 最好不用
     */
    private boolean find1(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 最初的思路：
     * 第一行 折半查找，找到这个数或者找到比这数小的数
     * <p>
     * 再按这一列数据，顺序找，找不到 换前一行，一直找到为止
     */
    private boolean find2(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        //一共多少列
        int cols = array.length;
        // 一共多少行
        int rows = array[0].length;
        if (rows == 0) {
            return false;
        }
        int left = 0, right = cols - 1;
        //中间列
        int midCols = left + (right - left) / 2;
        //先第一行折半查找
        while (left < right) {
            if (array[0][midCols] > target) {
                right = midCols - 1;
            } else if (array[0][midCols] < target) {
                left = midCols + 1;
            } else {
                break;
            }
            midCols = left + (right - left) / 2;
        }
        if (array[0][midCols] == target) {
            return true;
        }
        /**
         * array[0][midCols] 是这一行最接近target 的值，
         * array[0][midCols] 可能比target大，可能比target小
         * 此处还有小优化，比如比最后一个大如何等等
         * 但在下面2个循环还是暴力破解
         */
        for (int j = midCols; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 2维折半查找 （优化于 行折半查找，列顺序查找）
     * 行列都进行折半，但都必须同时执行
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find3(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        //一共多少列
        int cols = array.length;
        // 一共多少行
        int rows = array[0].length;
        if (rows == 0) {
            return false;
        }
        int left = 0, right = cols - 1;
        //中间列
        int midCols = left + (right - left) / 2;
        //先第一行折半查找
        while (left < right) {
            if (array[0][midCols] > target) {
                right = midCols - 1;
            } else if (array[0][midCols] < target) {
                left = midCols + 1;
            } else {
                break;
            }
            midCols = left + (right - left) / 2;
        }
        if (array[0][midCols] == target) {
            return true;
        }
        /**
         * 每一列折半
         */
        for (int j = midCols; j >= 0; j--) {
            int top = 0, bottom = rows - 1;
            int midRows = top + (bottom - top) / 2;
            while (top < bottom) {
                if (array[midRows][j] > target) {
                    bottom = midRows - 1;
                } else if (array[midRows][j] < target) {
                    top = midRows + 1;
                } else {
                    break;
                }
                midRows = top + (bottom - top) / 2;
            }
            if (array[midRows][j] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从左下角开始找
     * 每行 从左->右递增
     * 每列 从上->下 递增
     * 对于左下角的数m 是该列最大的数  是该行最小的数
     * 当m=target 返回true 找到值
     * 当m<target  该列已经最大，该行最小数 想找更大的数，只能从行上 向右找，则列数右移一位 列数+1
     * 当m>target  该列已经最大，该行最小数 想找更小的数，只能从列上 向上找，则行数上移一位 行数-1
     *
     * 时间复杂度：O(行高 + 列宽)O(行高+列宽)
     * 空间复杂度：O(1)O(1)
     */
    public boolean find4(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        //一共多少列
        int cols = array.length;
        if (cols == 0) {
            return false;
        }
        // 一共多少行
        int rows = array[0].length;
        if (rows == 0) {
            return false;
        }
        //左下角的数
        int r = rows - 1, c = 0;
        for (; r >= 0 && c < cols; ) {
            if (array[r][c] > target) {
                r--;
            } else if (array[r][c] < target) {
                c++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 从右上角开始找
     * 每行 从左->右递增
     * 每列 从上->下 递增
     * 对于右上角的数m 是该行最大的数  是该列最小的数
     * 当m=target 返回true 找到值
     * 当m<target  该列已经最小，该行最大数 想找更大的数，只能从列上 向下找，则行数下移一位 行数+1
     * 当m>target  该列已经最小，该行最大数 想找更小的数，只能从行上 向左找，则列数左移一位 列数-1
     * 时间复杂度：O(行高 + 列宽)O(行高+列宽)
     * 空间复杂度：O(1)O(1)
     */
    public boolean find5(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        //一共多少列
        int cols = array.length;
        if (cols == 0) {
            return false;
        }
        // 一共多少行
        int rows = array[0].length;
        if (rows == 0) {
            return false;
        }
        //右上角的数
        int r = 0, c = cols - 1;
        for (; r < rows && c >= 0; ) {
            if (array[r][c] > target) {
                c--;
            } else if (array[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }


}
