package com.example.arithmetic.arithmeticstu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author xiaobao.chen
 * Create at 2020-07-05
 */
public class offer2020070501 {

    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int[] a = new int[list.size()];
        int count = a.length - 1;
        for (Integer num : list) {
            a[count] = num;
            count--;
        }
        return a;
    }

    public int[] reversePrint1(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            ListNode cur = temp.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
            length++;
        }

        System.out.println(length);
        int[] a = new int[length];
        int count = 0;
        ListNode temp2 = pre;
        while (temp2 != null) {
            a[count] = temp2.val;
            temp2 = temp2.next;
            count++;
        }
        return a;
    }
}
