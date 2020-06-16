package com.example.arithmetic.arithmeticstu.tree;

/**
 *
 * https://www.cnblogs.com/maybe2030/p/4732377.html
 * 二叉树：父节点只有两个子节点。
 * 二叉搜索树：左节点 小于 右节点。
 * 平衡二叉树：又称AVL树。它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，
 *          并且左右两个子树都是一棵平衡二叉树。平衡二叉树的常用算法有红黑树、AVL树等
 * 红黑树：1.根节点肯定是黑色
 *       2.叶子节点肯定是黑色的。
 *       3.只存在黑色和红色两种节点
 *       4.红色节点的左右节点肯定是黑色的。（从每个叶子到根的所有路径上不能有两个连续的红色节点）
 *       5.从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点
 * 用途：类型hashmap 做数据的存储。
 * 原理：限制了路径的长度，最长不会超过最短的二倍。插入，删除等效率比较高。
 *
 * B树：查找比较快。
 * B+树：
 *
 *
 *
 *
 * https://www.cnblogs.com/liuyang0/p/6271331.html
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020042401 {

    private TreeNode root = null;

    public Arithmetic2020042401(TreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        //        theFirstTraversal(root);
        //        System.out.println("...........");
        //        theMiddleTraversal(root);
        //        System.out.println("...........");
        //        theRightTraversal(root);
        //        System.out.println(findKey(root, 7).val);
        //        System.out.println(insert(root, 10));
        System.out.println(deepth(root));
        levelOrder(root);
    }

    /**
     * 查找。
     *
     * @param root
     * @param value
     * @return
     */
    public static TreeNode findKey(TreeNode root, int value) {
        TreeNode current = root;
        while (true) {
            if (current.val == value) {
                return current;
            } else if (value < current.val) {
                current = current.left;
            } else if (value > current.val) {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
    }

    public static String insert(TreeNode root, int value) {
        TreeNode node = new TreeNode(value, null, null);
        if (root == null) {
            root = node;
            return "success!";
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (true) {
            if (value < current.val) {
                parent = current;
                current = current.getLeft();
                if (current == null) {
                    parent.left = node;
                    return "success";
                }
            } else if (value > current.val) {
                parent = current;
                current = current.getRight();
                if (current == null) {
                    parent.right = node;
                    return "success";
                }
            } else {
                return "name";
            }
        }
    }

    /**
     * 树的初始化
     *
     * @return
     */
    public static TreeNode buildTree() {
        TreeNode a = new TreeNode(2, null, null);
        TreeNode b = new TreeNode(4, null, null);
        TreeNode c = new TreeNode(8, null, null);

        TreeNode d = new TreeNode(1, null, a);
        TreeNode e = new TreeNode(5, b, null);
        TreeNode f = new TreeNode(7, null, c);

        TreeNode g = new TreeNode(3, d, e);
        TreeNode h = new TreeNode(9, f, null);
        TreeNode i = new TreeNode(6, g, h);

        return i;
    }

    public static void printNode(TreeNode node) {
        System.out.print(node.getVal());
    }

    /****
     * 前序遍历： 根节点--左节点---右节点
     *
     *
     * 中序遍历：左节点--根节点--右节点
     *
     *
     * 后序遍历：左节点---右节点--根节点
     */

    /**
     * 前序遍历
     *
     * @param node--根节点。
     */
    public static void theFirstTraversal(TreeNode node) {
        printNode(node);
        if (node.getLeft() != null) {
            theFirstTraversal(node.getLeft());
        }
        if (node.getRight() != null) {
            theMiddleTraversal(node.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param node--根节点。
     */
    public static void theMiddleTraversal(TreeNode node) {
        if (node.getLeft() != null) {
            theMiddleTraversal(node.getLeft());
        }
        printNode(node);
        if (node.getRight() != null) {
            theFirstTraversal(node.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param node--根节点。
     */
    public static void theRightTraversal(TreeNode node) {
        if (node.getLeft() != null) {
            theRightTraversal(node.getLeft());
        }
        if (node.getRight() != null) {
            theRightTraversal(node.getRight());
        }
        printNode(node);
    }

    /**
     * 层序遍历
     *
     * @param node
     */
    public static void levelOrder(TreeNode node) {
        int levelDeepth = deepth(node);

        for (int i = 1; i <= levelDeepth; i++) {
            levelOrder(node, i);
        }
    }

    public static void levelOrder(TreeNode node, int level) {
        if (node == null || level < 1) {
            return;
        }
        if (level == 1) {
            System.out.println("value:" + node.val);
            return;
        }

        levelOrder(node.left, level - 1);
        levelOrder(node.right, level - 1);
    }

    /**
     * 获取树的深度
     *
     * @param node
     * @return
     */
    public static int deepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = deepth(node.left);
        int r = deepth(node.right);

        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
