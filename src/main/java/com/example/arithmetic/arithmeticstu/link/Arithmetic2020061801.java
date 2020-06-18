package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * <p>
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061801 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        int len = 0;
        while (first != null) {
            len++;
            first = first.next;
        }

        int cycleStep = k % len;
        first = head;
        int step = 0;
        while (first.next != null && step < cycleStep) {
            first = first.next;
            step++;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }
}
