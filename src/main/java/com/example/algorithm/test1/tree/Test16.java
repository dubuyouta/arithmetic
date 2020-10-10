package com.example.algorithm.test1.tree;


import com.example.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2019/11/22 15:54
 */
public class Test16 {
    /**
     * 题目：
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * 分析：代码鲁棒性=系统稳定性 能接受异常处理
     *
     * 一个根节点的子树 只有它本身 和 左子树 ，右子树
     *
     * 一棵大树 A，一棵小树 B，若 B 是 A 的子树，则：
     *
     * B 和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
     * 或者 B 的左孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
     * 或者 B 的右孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
     *
     * 如果其中一块结果 重合与数结构，叫做子结构
     */

    public static void main(String[] args) {
        Test16 test = new Test16();

        TreeNode root1 = new TreeNode(1);

        TreeNode a = new TreeNode(3);

        TreeNode b = new TreeNode(5);

        root1.left = a;

        root1.right = b;

        TreeNode c = new TreeNode(8);

        TreeNode d = new TreeNode(4);

        TreeNode e = new TreeNode(2);

        TreeNode f = new TreeNode(10);

        a.left = c;

        b.right = d;

        c.right = e;

        e.left = f;

        //root1.print();

        // System.out.println(JSON.toJSONString(test.preOrderTraversal(root1)));

        System.out.println(test.hasSubtree3(root1, c));


    }


    /**
     * 判断 root2 是不是 root1 的子树
     * 将2棵树 都转成前序遍历 数组 然后 看数组 中是否包含 数组 2
     * 或者数组包含数组1
     *
     * 转变成前序  是 按照子结构去找的
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> list1 = preOrderTraversal(root1);
        List<Integer> list2 = preOrderTraversal(root2);
        if (list1 == null || list2 == null) {
            return false;
        }
        List<Integer> more = null;
        List<Integer> less = null;
        if (list1.size() >= list2.size()) {
            more = list1;
            less = list2;
        } else {
            less = list2;
            more = list1;
        }

        return more.containsAll(less);
    }

    public boolean hasSubtree1(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> list1 = preOrderTraversal(root1);
        List<Integer> list2 = preOrderTraversal(root2);
        if (list1 == null || list2 == null) {
            return false;
        }
        List<Integer> more = null;
        List<Integer> less = null;
        if (list1.size() >= list2.size()) {
            more = list1;
            less = list2;
        } else {
            less = list2;
            more = list1;
        }

        return more.containsAll(less);
    }

    /**
     * 比较更节点的结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        /**
         * 将同级别的 结点  左子树 或中右子树 传入
         */
        return doesTree1HasTree2(root1, root2) ||
                doesTree1HasTree2(root1.left, root2) ||
                doesTree1HasTree2(root1.right, root2);
    }


    /**
     * 此处 tree1 和 tree2 是对应原树 中 相同结构的根节点
     * @param tree1
     * @param tree2
     * @return
     */
    private boolean doesTree1HasTree2(TreeNode tree1, TreeNode tree2) {
        /**
         * 找到 tree2 为空 说明 前面都符合要求，否则早就返回 false
         */
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        /**
         * 每次是同级别的根节点 查找
         */
        return doesTree1HasTree2(tree1.left, tree2.left) && doesTree1HasTree2(tree1.right, tree2.right);
    }


    public boolean hasSubtree3(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        /**
         * 将同级别的 结点  左子树 或中右子树 传入
         */
        return judgeSubTree(root1, root2) ||
                judgeSubTree(root1.left, root2) ||
                judgeSubTree(root1.right, root2);
    }

    /**
     * 判断 子结构的数据
     * @param root1
     * @param root2
     * @return
     */
    private boolean judgeSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            //当值不相等继续往往下找，直到找到相同的结点为止
            return judgeSubTree(root1.left, root2) ||
                    judgeSubTree(root1.right, root2);
        }
        return judgeSubTree(root1.left, root2.left) &&
                judgeSubTree(root1.right, root2.right);
    }

    /**
     * 前序遍历 根左右
     * 对每一棵子树 均是 根左右
     * @param treeNode
     * @return
     */
    private List<Integer> preOrderTraversal(TreeNode treeNode) {
        /**
         * 需要一个栈来存储当前分支的有节点
         */
        if (treeNode == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);

        while (!stack.empty()) {
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        return list;
    }


}
