package com.example.algorithm.test1.tree;


import com.example.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 15:07
 */
public class Test25 {
    /**
     * 题目：2叉搜索数 与 双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     *  2叉搜索数  : 所有 左子树 结点 小于等于 根节点
     *              所有  右子树 结点  大于等于 根节点
     *
     *              子树 也是递归2叉搜索数
     *
     *    如例子： 二叉搜索数
     *                      10
     *                    /    \
     *                  5       15
     *               /    \    /   \
     *             3      8   11    18
     *              \    /   / \    /
     *              4   7   9  12  17
     *
     */

    public static void main(String[] args) {
        Test25 test = new Test25();
        TreeNode root = new TreeNode(10);

        TreeNode a = new TreeNode(5);
        root.left = a;
        TreeNode b = new TreeNode(15);
        root.right = b;

        TreeNode c = new TreeNode(3);
        a.left = c;
        TreeNode d = new TreeNode(8);
        a.right = d;
        TreeNode e = new TreeNode(11);
        b.left = e;
        TreeNode f = new TreeNode(18);
        b.right = f;

        TreeNode g = new TreeNode(4);
        c.right = g;
        TreeNode h = new TreeNode(7);
        d.left = h;
        TreeNode i = new TreeNode(9);
        e.left = i;
        TreeNode j = new TreeNode(12);
        e.left = j;

        TreeNode k = new TreeNode(17);
        f.left = k;
    }

    /**
     * 解题，需要了解怎么变化  没做出来，需要再看看
     * 解题1 先中序遍历 左 根 右 得到一个有序的列表，再将list数据 左右相连
     * @param pRootOfTree
     * @return
     */
    private TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        //做中序遍历存放的结果
        List<TreeNode> list=new ArrayList<>();
        //做中序遍历使用
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=pRootOfTree;
        while (current!=null||!stack.isEmpty()){
            while(current != null) {
                //把这个根节点下 所有左节点放入栈中
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                //将放入栈中的数据 取出栈最上层左节点，即 叶子 左节点 取出一个
                current = stack.pop();
                list.add(current);
                //上一个已经找到最节点的叶子节点  但最后这个节点可能没有左孩子，但是有右孩子
                //所以从有孩子继续找
                current = current.right;
            }
        }

        /**
         * 转换指针 转变成一个序列之后就是左右相连的问题
         */
        for (int i = 0; i < list.size(); i++) {
            TreeNode left = i == 0 ? null : list.get(i - 1);
            TreeNode right = i == list.size() - 1 ? null : list.get(i + 1);
            list.get(i).left = left;
            list.get(i).right = right;
        }
        return list.get(0);
    }


}
