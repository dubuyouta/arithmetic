package com.example.arithmetic.arithmeticstu.link;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author xiaobao.chen
 * Create at 2020/6/4
 */
public class Arithmetic2020060403 {

    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> countMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            int count = countMap.get(temp.val) == null ? 0 : countMap.get(temp.val);
            countMap.put(temp.val, count++);
            temp = temp.next;
        }
        ListNode temp3 = new ListNode(-1);
        temp3.next = head;
        ListNode temp2 = temp3;
        while (temp2.next != null) {
            int count = countMap.get(temp2.next.val) == null ? 0 : countMap.get(temp2.next.val);
            if (count > 1) {
                temp2.next = temp2.next.next;
            } else {
                temp2 = temp2.next;
            }
        }
        return temp3.next;
    }
}
