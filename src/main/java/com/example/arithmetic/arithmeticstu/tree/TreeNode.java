package com.example.arithmetic.arithmeticstu.tree;

/**
 * 树 node 数据结构  https://segmentfault.com/a/1190000014743964
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


}
