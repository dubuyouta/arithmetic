package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020060902 {

    /**
     * 很巧妙的解法
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
