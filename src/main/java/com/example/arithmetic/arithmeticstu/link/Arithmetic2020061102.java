package com.example.arithmetic.arithmeticstu.link;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061102 {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = head;
        while (temp != null) {
            if (!set.contains(temp.val)) {
                set.add(temp.val);
                pre = temp;
            } else {
                pre.next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
