package com.example.algorithm.test1.tree;

import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.Arrays;

public class Test4 {
    /**
     * 题目 根据前序 和 中序 重建 二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * <p>
     * 要点 ：1.二叉树的结构是什么 ？
     * 每一个结点可以有左右孩子，所以返回一个树行结构，并非返回一个数组
     * <p>
     * 2.前序遍历和中序遍历的规则是什么？
     * <p>
     * 前序遍历 ：根结点->左子树->右子树
     * <p>
     * 中序遍历：左子树->根结点->右子树
     * <p>
     * 后序遍历：左子树->右子树->根结点
     * <p>
     * 注：以上3种遍历，每一种 子树结构都递归的要符合上面的结构
     * <p>
     * 3.如何根据前序和中序  推测原来的二叉数据？
     * <p>
     * 1.首先前序遍历 确定 根节点 ，如上例 根节点=1
     * 2.确定根，在中序中，找到根节点位置 ，从根到之前数 都为 最子树 4,7,2 左子树
     * 5,3,8,6 右子树
     * <p>
     *       1
     *      / \
     *     2   3
     *    /   / \
     *   4   5   6
     *   \      /
     *   7     8
     * <p>
     * <p>
     * 根据当前  前序序列  的第一个结点确定根结点，为 1
     * 找到 1 在中序遍历序列中的位置， 为 in[3]
     * 切割左右子树， 则 in[3] 前面的为左子树，  in[3] 后面的为右子树
     * 则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；
     * 切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
     * 对子树分别使用同样的方法分解 (此处可以循环 也可以递归)
     * <p>
     * 前序遍历 如何根据根据中序遍历 来切分左右子树
     */

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        test4.reConstructBinaryTree1(pre, in).print();

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        //第一步 找到根绝点
        int rootNode = pre[0];
        //第二步 找到中序遍历中，根节点位置
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootNode) {
                rootIndex = i;
                break;
            }
        }
        //第三步 中序遍历 从rootIndex 分为 0- rootIndex-1 为左子树  从 rootIndex+1 -in.lengt-1 为右子树
        int[] inLeftTree = Arrays.copyOfRange(in, 0, rootIndex);
        System.out.println(Arrays.toString(inLeftTree));
        int[] inRightTree = Arrays.copyOfRange(in, rootIndex + 1, in.length);
        System.out.println(Arrays.toString(inRightTree));
        //第四部 根据中序左右子树  找到前序左右子树的切割点
        int preIndex = 0;
        for (int i = 1; i < pre.length; i++) {
            boolean flag = false;
            for (int j = 0; j < inLeftTree.length; j++) {
                if (pre[i] == inLeftTree[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                preIndex = i;
                break;
            }
        }
        //第四部 前序遍历 从 preIndex 切割成 左右子树
        int[] preLeftTree = Arrays.copyOfRange(pre, 1, preIndex);
        System.out.println(Arrays.toString(preLeftTree));
        int[] preRightTree = Arrays.copyOfRange(pre, preIndex, pre.length);
        System.out.println(Arrays.toString(preRightTree));

        return null;

    }

    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            //中序中找到切割的位置
            if (pre[0] == in[i]) {
                //左子树 由前序的左子树 和 中序 的左子树 构成 递归构成
                /**
                 * 技巧：前序的切割，通过中序的位置确定左子树的个数，
                 * 在前序中 除了根节点，移动 左子树个数就找到左子树的构成
                 * 注：前序 i+1  是除掉根节点+1个
                 * 中序找到第i个结点 已经是根节点  所以中序 左子树=0~i-1 故切割为 0，i 不包括 Arrays.copyOfRange 包括
                 * from 不包括 to
                 */
                treeNode.left = reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));
                //右子树
                treeNode.right = reConstructBinaryTree1(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return treeNode;
    }

}

