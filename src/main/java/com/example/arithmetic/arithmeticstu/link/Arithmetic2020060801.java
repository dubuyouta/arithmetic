package com.example.arithmetic.arithmeticstu.link;

/**
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020060801 {

    /**
     * 通过递归的方式进行两两替换。
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
