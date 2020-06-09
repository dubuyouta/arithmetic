package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020060901 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoKLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoKLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
