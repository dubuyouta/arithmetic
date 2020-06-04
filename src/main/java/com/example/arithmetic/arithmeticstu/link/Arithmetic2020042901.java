package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author xiaobao.chen
 * Create at 2020/4/28
 */
public class Arithmetic2020042901 {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        ListNode p = l1, q = l2;
        int preSum = 0;
        while (p != null || q != null) {
            int num1 = p != null ? p.val : 0;
            int num2 = q != null ? q.val : 0;
            int sum = num1 + num2 + preSum;
            preSum = sum / 10;

            if (head == null) {
                head = new ListNode(sum % 10);
                temp = head;
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }

            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }
        if (preSum > 0) {
            temp.next = new ListNode(preSum);
        }
        return head;
    }
}
