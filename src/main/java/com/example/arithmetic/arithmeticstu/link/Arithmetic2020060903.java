package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020060903 {

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }

    /**
     * 采用递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
