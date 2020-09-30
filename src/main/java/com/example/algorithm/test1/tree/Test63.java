package com.example.algorithm.test1.tree;

import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2020/6/2 17:34
 */
public class Test63 {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
     * （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     *
     * 思路对于二叉搜索树来说，中序遍历，刚好输出 从小到大的排序序列
     *               10
     *             /    \
     *            5      15
     *          /  \    /  \
     *         3    9  12   18
     *         \    /   \   /
     *         4   6    13 16
     *
     *         中序遍历：3,4,5,6,9,10,12,13,15,16,18
     */

    public static void main(String[] args) {
        Test63 test63 = new Test63();

        TreeNode root = new TreeNode(10);

        TreeNode a = new TreeNode(5);
        root.left = a;
        TreeNode b = new TreeNode(15);
        root.right = b;

        TreeNode c = new TreeNode(3);
        a.left = c;
        TreeNode d = new TreeNode(9);
        a.right = d;
        TreeNode e = new TreeNode(12);
        b.left = e;
        TreeNode f = new TreeNode(18);
        b.right=f;

        TreeNode g = new TreeNode(3);
        c.right = g;
        TreeNode h = new TreeNode(9);
        d.left=h;
        TreeNode i = new TreeNode(13);
        e.right = i;
        TreeNode j = new TreeNode(16);
        f.left=j;

        TreeNode node=test63.kthNode(root,5);
        System.out.println(node.val);


    }

    //设置中序遍历
    private TreeNode searchNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        int popNum=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode currentNode=root;
        while (!stack.isEmpty()||currentNode!=null){
            if(currentNode!=null){
                stack.push(currentNode);
                currentNode=currentNode.left;
            }else{
                currentNode=stack.pop();
                popNum++;
                if(popNum==k){
                    return currentNode;
                }
                currentNode=currentNode.right;
            }
        }
        return null;
    }

    //递归中序遍历
    int index=0;
    private TreeNode kthNode(TreeNode root, int k){
        if(root==null||k<=0){
            return null;
        }
        TreeNode node=kthNode(root.left,k);
        if(node!=null){
            return node;
        }
        index++;
        if(k==index){
            return root;
        }
        node = kthNode(root.right,k);
        if(node != null) {
            return node;
        }
        return null;

    }
}
