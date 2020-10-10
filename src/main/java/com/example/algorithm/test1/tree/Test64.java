package com.example.algorithm.test1.tree;

import com.alibaba.fastjson.JSON;
import com.example.algorithm.bo.TreeNode;

import java.util.*;

/**
 * @author: heshineng
 * @createdBy: 2020/6/2 20:28
 */
public class Test64 {
    /**
     * 使用多种方式，遍历二叉树
     * 遍历二叉树的方式：先序遍历，中序遍历，后序遍历，层序遍历，广度优先遍历（BFS），深度优先遍历（DFS）
     *
     * 其中总体遍历方式只有4种：
     *            先序遍历=前序遍历=深度优先遍历 ===》根左右
     *            中序遍历                     ===》 左根右
     *            后序遍历                     ===》左右根
     *            层序遍历=广度优先            ====》 一层一层 ，结点从左到右遍历
     *
     *       这其中每一种遍历，又分为递归与非递归方式
     *
     *                1
     *              /   \
     *            2      3
     *            \     / \
     *            4    5   6
     *
     *            先序遍历：1,2,4,3,5,6
     *            中序遍历：2,4,1,5,3,6
     *            后序遍历：4,2,5,6,3,1
     *            层序遍历：1,2,3,4,5,6
     */

    public static void main(String[] args) {
        Test64 test64 = new Test64();
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        root.left = a;
        TreeNode b = new TreeNode(3);
        root.right = b;

        TreeNode c = new TreeNode(4);
        a.left = c;
        TreeNode d = new TreeNode(5);
        b.left = d;
        TreeNode e = new TreeNode(6);
        b.right = e;

        System.out.println("先序非递归：" + JSON.toJSONString(test64.preOrderTraversal(root)));
        System.out.println("先序非递归1：" + JSON.toJSONString(test64.preOrderTraversal1(root)));
        System.out.println("先序递归：" + JSON.toJSONString(test64.preOrderTraversalByRecursion(root)));
        System.out.println();
        System.out.println("中序非递归：" + JSON.toJSONString(test64.inOrderTraversal(root)));
        System.out.println("中序递归：" + JSON.toJSONString(test64.inOrderTraversalByRecursion(root)));
        System.out.println();
        System.out.println("后序非递归：" + JSON.toJSONString(test64.postOrderTraversal(root)));
        System.out.println("后序非递归1：" + JSON.toJSONString(test64.postOrderTraversal2(root)));
        System.out.println("后序递归：" + JSON.toJSONString(test64.postOrderTraversalByRecursion(root)));
        System.out.println();
        System.out.println("层序非递归：" + JSON.toJSONString(test64.levelOrderTraversal(root)));
        System.out.println("层序递归：" + JSON.toJSONString(test64.levelOrderTraversalByRecursion(root)));
    }

    //先序遍历，非递归方式
    private List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    //先序遍历 ,非递归方式2
    private List<Integer> preOrderTraversal1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                list.add(currentNode.val);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
        return list;
    }

    //先序遍历，递归方式
    private List<Integer> preOrderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //递归思路，先根再右，再左
        preOrderTraversalByRecursion(root, list);
        return list;
    }

    private void preOrderTraversalByRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //递归思路，先跟，->左 ->右  递归就是从最初含义触发，获取值
        //根左右
        list.add(root.val);
        preOrderTraversalByRecursion(root.left, list);
        preOrderTraversalByRecursion(root.right, list);
    }

    //中序遍历，非递归方式
    private List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        //左根右
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                list.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return list;
    }

    //中序遍历，递归方式
    private List<Integer> inOrderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversalByRecursion(root, list);
        return list;
    }

    private void inOrderTraversalByRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //左根右
        inOrderTraversalByRecursion(root.left, list);
        list.add(root.val);
        inOrderTraversalByRecursion(root.right, list);
    }

    //后序遍历，非递归方式  这种方式没写出来
    private List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        TreeNode preNode = null;
        stack.push(currentNode);
        while (!stack.isEmpty()) {
            //每一个在栈中的结点，先右孩子入栈，再左孩子入栈
            currentNode = stack.peek();
            /**
             * 当前节点没有子结点，就是叶子结点，可以出栈
             */
            if ((currentNode.right == null && currentNode.left == null)
                    || (preNode != null && (preNode == currentNode.left || preNode == currentNode.right))) {
                //前一个结点为当前节点的子结点，代表子结点已经如果一次栈，之后可以直接出栈
                //出栈
                stack.pop();
                list.add(currentNode.val);
                preNode = currentNode;
            } else {
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            }
        }
        return list;
    }

    //后序遍历，非递归方式1  这种方式没写出来
    private List<Integer> postOrderTraversal2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        TreeNode preNode = null;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else if (!stack.isEmpty()) {
                currentNode = stack.peek();
                if (currentNode.right == null || currentNode.right == preNode) {
                    //右节点等于前一个结点，代表右节点之前已经如果栈了，只要出栈就可以了
                    currentNode = stack.pop();
                    list.add(currentNode.val);
                    preNode = currentNode;
                    currentNode = null;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return list;
    }

    //后序遍历，递归方式 字面理解 左根右
    private List<Integer> postOrderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalByRecursion(root, list);
        return list;
    }

    private void postOrderTraversalByRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //左右根
        postOrderTraversalByRecursion(root.left, list);
        postOrderTraversalByRecursion(root.right, list);
        list.add(root.val);
    }

    //层序遍历，非递归方式
    private List<Integer> levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
//            boolean flag=node.left!=null&&queue.add(node.left);
//            flag=node.right!=null&&queue.add(node.right);
        }
        return list;
    }

    //层序遍历，递归方式
    private List<Integer> levelOrderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> tempList = new ArrayList<>();
        levelOrderTraversalByRecursion(tempList, root, 1);
        tempList.forEach(item -> {
            list.addAll(item);
        });
        return list;
    }

    private void levelOrderTraversalByRecursion(List<List<Integer>> tempList, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (tempList.size() < level) {
            tempList.add(new ArrayList<>());
        }
        tempList.get(level - 1).add(root.val);
        levelOrderTraversalByRecursion(tempList, root.left, level + 1);
        levelOrderTraversalByRecursion(tempList, root.right, level + 1);
    }
}
