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

    /***
     * 使用双指针
     * 1.需要一个哑结点
     * 2.a指针和b指针
     * 3.当a 指针指向的数据和b指针指向的数据不同时，同时移到下一个，
     *   相同时。b指针指向下一个，直到不同为止。
     *
     *   总结：1.哑结点的设置
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode tmpl = new ListNode(-1);
        tmpl.next = head;
        ListNode a = tmpl;
        ListNode b = head;
        while (b != null && b.next != null) {
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return tmpl.next;
    }
}
