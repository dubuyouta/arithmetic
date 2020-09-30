package com.example.algorithm.test1.tree;

import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.LinkedList;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 0:30
 */
public class Test17 {
    /**
     * 题目：
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *    二叉树的镜像定义：源二叉树
     *     	     8                                8
     *     	   /  \                              / \
     *     	  6   10        镜像二叉树         10   6
     *     	 / \  / \                         / \  / \
     *     	5  7 9 11                        11 9 7  5
     *     	镜像二叉树
     *
     *   特点 ：延更节点中轴线 左右对称镜面反转
     */

    public static void main(String[] args) {
        Test17 test = new Test17();

        TreeNode root = new TreeNode(8);

        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(10);

        root.left = a;
        root.right = b;

        TreeNode c = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        a.left = c;
        a.right = e;

        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        b.left = f;
        b.right = g;

        //root.print();

        //test.mirror(root);

        test.mirror1(root);

        root.print();


    }

    /**
     * 从根结点开始，每个结点的左右结点交换
     * @param root
     */
    public void mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        swap(root);
        swapTowChildTree(root.left, root.right);
    }

    /**
     * 主要将 每个结点左右结点交换  并从根结点开始
     * @param root
     */
    public void mirror1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            TreeNode currentNode = linkedList.pop();
            swap(currentNode);

            if (currentNode.left != null) {
                linkedList.add(currentNode.left);
            }
            if (currentNode.right != null) {
                linkedList.add(currentNode.right);
            }
        }
    }

    /**
     * 简单左右子树交换
     * @param root
     */
    public void mirror2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirror2(root.left);
        mirror2(root.right);
    }

    //2个相同级别的子树 进行交换结点
    public void swapTowChildTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 != null) {
            swap(tree1);
            swapTowChildTree(tree1.left, tree1.right);
        }
        if (tree2 != null) {
            swap(tree2);
            swapTowChildTree(tree2.left, tree2.right);
        }
    }

    private void swap(TreeNode tree) {
        if (tree == null)
            return;
        TreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

}
