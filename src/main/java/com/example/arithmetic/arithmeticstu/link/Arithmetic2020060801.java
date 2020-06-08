package com.example.arithmetic.arithmeticstu.link;

/**
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020060801 {

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
