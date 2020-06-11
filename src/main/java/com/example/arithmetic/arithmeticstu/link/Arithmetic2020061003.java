package com.example.arithmetic.arithmeticstu.link;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061003 {

    /**
     * 通过借助外部集合来进行判断
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.contains(head)) {
                nodeSet.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针的方式：
     * 快指针每次走两步。
     * 慢指针每次走一步。
     * <p>
     * 最终两个指针肯定会遇见的，如果有环的话。
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
