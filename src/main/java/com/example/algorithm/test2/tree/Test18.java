package com.example.algorithm.test2.tree;

import com.example.algorithm.bo.TreeNode;

/**
 * @author: heshineng
 * @createdBy: 2020/7/27 16:11
 */
public class Test18 {
    /**
     * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，
     * 对于树中的任意一个结点，其两颗子树的高度差不超过1。
     *
     * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡
     */

    public static void main(String[] args) {

        Test18 test18 = new Test18();
        TreeNode rootNode = new TreeNode(4);

        TreeNode a = new TreeNode(6);
        rootNode.left = a;
        TreeNode b = new TreeNode(8);
        rootNode.right = b;

        TreeNode c = new TreeNode(2);
        a.left = c;
        TreeNode d = new TreeNode(1);
        a.right = d;
        TreeNode e = new TreeNode(3);
        b.left = e;
        TreeNode f = new TreeNode(5);
        b.right = f;

        TreeNode g = new TreeNode(6);
        f.right = g;

        TreeNode h = new TreeNode(10);
        g.left=h;

        System.out.println(test18.isBalance1(rootNode));
    }

    /**
     * 思路，从定义入手，直接判断平衡不好判断
     * 但是可以使用递归判断不平衡
     * @param treeNode
     * @return
     */
    private boolean isBalance(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        int left = searchTreeDepth(treeNode.left);
        int right = searchTreeDepth(treeNode.right);
        if (Math.abs(left - right) < 2) {
            return isBalance(treeNode.left) && isBalance(treeNode.right);
        }
        return false;
    }

    /**
     * 计算一个结点的深度
     * @return
     */
    private int searchTreeDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = searchTreeDepth(treeNode.left);
        int right = searchTreeDepth(treeNode.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 上面的递归太多了，在某一层不符合应该返回，但是
     * 上面的逻辑还在继续
     * @param treeNode
     * @return
     */
    private boolean isBalance1(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        searchTreeDepth1(treeNode);
        return flag;
    }

    private boolean flag=true;

    private int searchTreeDepth1(TreeNode treeNode) {
        if (!flag || treeNode == null) {
            if(!flag){
                System.out.println("12 "+flag);
            }
            return 0;
        }
        int left = searchTreeDepth1(treeNode.left);
        int right = searchTreeDepth1(treeNode.right);
        if(Math.abs(left - right) > 1){
            flag=false;
        }
        return Math.max(left, right) + 1;
    }

}
