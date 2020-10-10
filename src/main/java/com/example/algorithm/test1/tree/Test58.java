package com.example.algorithm.test1.tree;


import com.example.algorithm.bo.TreeLinkNode;

import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2020/5/28 18:42
 */
public class Test58 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * 中序遍历：左子树->根结点->右子树
     *         5
     *       /   \
     *      6     9
     *    /  \    / \
     *   4   3   2   10
     *       \       /
     *       7      11
     *
     *
     *       中序 4->6->3->7->5->2->9->11->10
     *
     *       如 9->11
     *
     */

    public static void main(String[] args) {
        Test58 test58 = new Test58();

        TreeLinkNode root = new TreeLinkNode(5);

        TreeLinkNode a = new TreeLinkNode(6);
        TreeLinkNode b = new TreeLinkNode(9);

        root.left = a;
        root.right = b;
        a.parent = b.parent = root;

        //左子树
        TreeLinkNode c = new TreeLinkNode(4);
        TreeLinkNode d = new TreeLinkNode(3);

        c.parent = d.parent = a;
        a.left = c;
        a.right = d;

        TreeLinkNode e = new TreeLinkNode(7);
        d.right = e;
        e.parent = d;

        //右子树
        TreeLinkNode f = new TreeLinkNode(2);
        TreeLinkNode g = new TreeLinkNode(10);
        b.left = f;
        b.right = g;
        f.parent = g.parent = b;

        TreeLinkNode h = new TreeLinkNode(11);
        g.left = h;
        h.parent = g;

        TreeLinkNode next=test58.getNext(e);


        System.out.println();
        System.out.println(next==null?"null":next.val);


    }

    /**
     * @param b 就是给定的结点
     *          最直接的思路，先找到根节点，然后按中序顺序输出
     *          输出到改结点的笑下一个结点就可以找到
     *
     *          优化思路，只要 能判断结点在左子树还是右子树，
     *          然后从根节点，进行到根节点就 开始 左子树还是右子树的中序
     *
     *         中序遍历的结果，使用栈，先沿着左子树不停入栈，直到没有左子树，再
     *          不停出，从右子树马不停入栈 再到出栈
     * @return
     */
    private TreeLinkNode searchNode(TreeLinkNode b) {
        /**
         * 此处有问题，如果为根节点
         *
         * 问题为，当为根节点时，下一个结点为 右子树中子结点遍历的值
         * b.parent == null 条件去掉
         */
        if (b == null) {
            return null;
        }
        TreeLinkNode currentNode = b;
        TreeLinkNode curParent = b.parent;
        /**
         * 需要判断当前节点是否为根节点
         */
        while (curParent!=null&&curParent.parent != null) {
            currentNode = currentNode.parent;
            curParent = curParent.parent;
        }
        //得到curParent 就是根节点
        Stack<TreeLinkNode> stack = new Stack<>();
        boolean isLeft=false;
        if(curParent!=null&&curParent.left==currentNode){
            isLeft=true;
        }
        boolean searchFlag=false;
        TreeLinkNode next=null;
        //不需要判断左子树还是右子树，currentNode为当前要遍历的子树
        while (currentNode!=null||!stack.isEmpty()){
            //先左子树不停入栈
            while (currentNode!=null){
                stack.add(currentNode);
                currentNode=currentNode.left;
            }
            if(!stack.isEmpty()){
                //目前出栈的，才是中序的结点
                currentNode=stack.pop();
                System.out.print(currentNode.val+" ");
                if(searchFlag){
                    //下一个结点
                    next=currentNode;
                    break;
                }
                if(currentNode==b){
                    searchFlag=true;
                }
                //开始遍历右子树结点
                currentNode=currentNode.right;
            }
        }
        /**
         * 如果查询是 左子树中序的最后一个元素，下一个就是跟根节点
         */
        if(isLeft&&next==null){
            next=curParent;
        }
        return next;
    }

    /**
     * 上面是常规做法，还有可以按给的结点所在位置分类讨论
     * 给的结点是否有有节点A
     *   1.有右节点A
     *        (1)右结点A，无左孩子，则直接返回右结点A
     *        (2)右结点A，有左孩子，一直遍历左孩子的左子树 到叶子结点 返回
     *   2.无右结点
     *       （1）判断给根节点，返回null
     *        (2) 不为根节点，判断当前节点是父节点的左孩子还是右孩子
     *            为左孩子，直接返回当前节点的父节点
     *            为右孩子：从父节点往上遍历，直到找到祖先节点为左孩子的父节点返回 否则返回null
     * @param pNode
     * @return
     */
    private TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }
        //有右结点
        if(pNode.right!=null){
            if(pNode.right.left==null){
                return pNode.right;
            }else{
                //右结点有左孩子，遍历到左孩子的叶子结点
                TreeLinkNode result=pNode.right.left;
                while (result.left!=null){
                    result=result.left;
                }
                return result;
            }
        }
        //无右结点
        if(pNode.parent==null){
            //当前节点为根节点，并且无右结点
            return null;
        }
        // 无右结点，但不为根节点，判断当前节点为父节点的左节点还是右结点
        if(pNode.parent.left==pNode){
            //当前节点为左孩子
            return pNode.parent;
        }
        //为右孩子，遍历先祖结点，判断先祖结点为左孩子的父节点返回
        TreeLinkNode tempParent=pNode.parent;
        while (tempParent.parent!=null){
            if(tempParent.parent.left==tempParent){
                return tempParent.parent;
            }
            tempParent=tempParent.parent;
        }
        return null;

    }
}
