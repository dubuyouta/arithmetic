package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020060901 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    //    public ListNode mergeKLists(ListNode[] lists) {
    //        ListNode ans = null;
    //        for (int i = 0; i < lists.length; i++) {
    //            ans = mergeTwoKLists(ans, lists[i]);
    //        }
    //        return ans;
    //    }

    /**
     * 二分法+递归
     *
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoKLists(l1, l2);
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
