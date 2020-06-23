package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
 * <p>
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020062201 {

    public ListNode detectCycle(ListNode head) {

    }

    public ListNode getCycle(ListNode node) {
        ListNode head = node;
        ListNode slow = node;
        while (head.next != null) {
            if (head == slow) {
                return slow;
            }
            head = head.next;
            slow = slow.next.next;
        }
        return null;
    }
}
