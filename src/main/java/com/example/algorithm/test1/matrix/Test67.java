package com.example.algorithm.test1.matrix;

/**
 * @author: heshineng
 * @createdBy: 2020/6/8 17:30
 */
public class Test67 {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，
     * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如
     * [a b c e]
     * [s f c s]
     * [a d e e]
     * 矩阵中包含一条字符串'bcced'的路径，但是矩阵中不包含'abcb'路径，
     * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     *
     * 回溯法：为了避免生成那些不可能产生最佳解的问题状态，要不断地利用限界函数(bounding function)
     * 来处死(剪枝)那些实际上不可能产生所需解的活结点，以减少问题的计算量。
     * 具有限界函数的深度优先生成法称为回溯法。（回溯法 = 穷举 +　剪枝）
     *
     * 深度优先加减枝
     */
    public static void main(String[] args) {
        Test67 test67 = new Test67();
        /**
         *  a b c e
         *  s f c s
         *  a d e e
         */
        char[][] matrix = new char[4][3];
        matrix[0] = new char[]{'a', 's', 'a'};
        matrix[1] = new char[]{'b', 'f', 'd'};
        matrix[2] = new char[]{'c', 'c', 'e'};
        matrix[3] = new char[]{'e', 's', 'e'};

        System.out.println(test67.hasPath(matrix, "cceda".toCharArray()));
    }


    /**
     * 0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
     * 1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge
     * 2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
     * 3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
     * 4.若k，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
     * 5.下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
     * 6.走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
     */
    private boolean hasPath(char[][] matrix, char[] str) {
        if (matrix == null || str == null) {
            return false;
        }
        int cols = matrix.length;
        int rows = matrix[0].length;
        if (cols < 1 || rows < 1 || str.length > cols * rows) {
            return false;
        }
        //标志位，初始化为false
        boolean[] visited = new boolean[cols * rows];
        /**
         * 遍历：从第一列从上往下开始遍历，然后第2列。。。
         */
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (hasPathCore(matrix, c, r, cols, rows, visited, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix 矩阵的数据
     * @param c  矩阵遍历索引列下标
     * @param r  矩阵遍历索引行下标
     * @param cols 矩阵列
     * @param rows 矩阵行
     * @param visited 查看这个起始的位置是否遍历开始过
     *                相对应将matrix的矩阵的数据拆开变为一行标记，数组的下标数据，对应
     *                矩阵的遍历方式 如：[0][0] [0][1] [0][2] (第一列数据) [1][0]  [1][0]  [1][0] 第2列数据
     *                对应的visited：{[0][0],[0][1],[0][2],[1][0],[1][0],[1][0]}
     *                     数组下标：   0   ,   1  ,   2  ,  3   ,   4  ,  5
     *                其中  visited数组下标=c*rows+r  他们的对应关系
     *
     *                注：visited 数组代表以一个起点，当为true，代表此位置走过了，如果这表路走不通时，还要将数据回溯归位，
     *                  给其他路线机会
     *
     * @param str 需要验证的字符数组
     * @param index 判断的字符串，字符串索引初始为0即先判断字符串的第一位) 每次找到一个头，都需要从第一个字符开始判断
     * @return
     */
    private boolean hasPathCore(char[][] matrix, int c, int r, int cols, int rows,
                                boolean[] visited, char[] str, int index) {
        if (index == str.length) {
            //匹配条件已经到达末尾 代表递归之前的数字都已经匹配到了
            return true;
        }
        //递归的遍历终止条件
        if (c >= cols || r >= rows || c < 0 || r < 0) {
            //横向纵向遍历有越界，说明匹配不了
            return false;
        }
        int visitedIndex = c * rows + r;
        //递归终止条件，当匹配到当前位置与对应目标字符对应位置不匹配 或者 该位置已经走过
        if (matrix[c][r] != str[index] || visited[visitedIndex] == true) {
            return false;
        }
        //设置要走的位置为true，当不匹配还要回溯复位
        visited[visitedIndex] = true;
        //回溯，递归寻找，每次找到了就给k加一，找不到，还原

        /**
         * 当前位置为 c列 r行，
         * 需要向上向下，向左，向右进行判断，是否可以往下匹配
         */

        //二维数组，向左匹配
        if (hasPathCore(matrix, c - 1, r, cols, rows, visited, str, index + 1) ||
                //二维数组 向右匹配
                hasPathCore(matrix, c + 1, r, cols, rows, visited, str, index + 1) ||
                //二维数组，向上匹配
                hasPathCore(matrix, c, r - 1, cols, rows, visited, str, index + 1) ||
                //二维数组,向下匹配
                hasPathCore(matrix, c, r + 1, cols, rows, visited, str, index + 1)) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        visited[visitedIndex] = false;
        return false;
    }


}
