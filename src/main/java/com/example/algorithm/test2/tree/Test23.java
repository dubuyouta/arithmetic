package com.example.algorithm.test2.tree;


import com.example.algorithm.bo.TreeNode;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/14
 */
public class Test23 {
    /**
     * 根据前序和中序遍历，构建二叉树
     */

    public static void main(String[] args) {
        Test23 test23 = new Test23();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        test23.reBuildTree(preOrder,inOrder).print();
    }

    /**
     * 前序遍历   根左右
     * 中学遍历   左根右
     * @param preOrder
     * @param inOrder
     * @return
     */
    private TreeNode reBuildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[0]);
        int rootIndex = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (preOrder[0] == inOrder[i]) {
                //找到中序的分界线
                rootIndex = i;
                break;
            }
        }
        /**
         * 中序找到 rootIndex个元素，如 4 取值（0,1,2,3,4,5,6,7,8）
         */
        treeNode.left = reBuildTree(Arrays.copyOfRange(preOrder, 1, rootIndex+1),
                Arrays.copyOfRange(inOrder, 0, rootIndex));
        treeNode.right = reBuildTree(Arrays.copyOfRange(preOrder, rootIndex+1, preOrder.length),
                Arrays.copyOfRange(inOrder, rootIndex + 1, inOrder.length));
        return treeNode;

    }
}
