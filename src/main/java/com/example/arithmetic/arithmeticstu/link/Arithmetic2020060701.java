package com.example.arithmetic.arithmeticstu.link;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 注意的是:链表中重复元素。
 *
 * @author xiaobao.chen
 * Create at 2020-06-07
 */
public class Arithmetic2020060701 {

    /**
     * 利用list 计算出总长度，
     * 利用count 找出对应的位置的数据
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        if (head == null) {
            return head;
        }

        ListNode temp = head;

        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }

        if (listNodes.size() < n) {
            return head;
        }

        int length = listNodes.size() - n - 1;

        ListNode nhead = new ListNode(-1);
        nhead.next = head;
        ListNode temp2 = nhead;
        int count = 1;

        while (temp2.next != null) {
            if (count < length) {
                temp2 = temp2.next;
                count++;
            } else if (count == length) {
                temp2.next = temp2.next.next;
                break;
            }
        }
        return nhead.next;
    }

    /**
     * 第一次循环 找出链表的长度。
     * 第二次循环，找到对应的位置进行删除。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        System.out.println(length);
        int target = length - n + 1;
        int initCount = 1;
        ListNode newListNode = new ListNode(-1);
        newListNode.next = head;
        ListNode delTemp = newListNode;
        while (delTemp.next != null) {
            if (initCount == target) {
                delTemp.next = delTemp.next.next;
                break;
            } else {
                delTemp = delTemp.next;
                initCount++;
            }
        }
        return newListNode.next;
    }

    /**
     * 双指针：
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode tmpl = new ListNode(-1);
        tmpl.next = head;

        ListNode temp = tmpl;
        ListNode tailTemp = tmpl;

        for (int i = 1; i <= n + 1; i++) {
            tailTemp = tailTemp.next;
        }

        while (tailTemp.next != null) {
            tailTemp = tailTemp.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return tmpl.next;
    }
}
