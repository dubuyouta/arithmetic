package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061001 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode temp = dumpHead;
        while (temp.next != null) {
            if (temp.next.val != val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return dumpHead.next;
    }
}
