package com.example.arithmetic.arithmeticstu.link;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * 移除重复节点，保留重复节点
 *
 * @author xiaobao.chen
 * Create at 2020/4/28
 */
public class Arithmetic2020042902 {

    public static void main(String[] args) {

    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        Map<Integer, Integer> countMap = new HashMap<>();
        ListNode temp = head;
        ListNode newHead = null;
        ListNode newTemp = null;
        while (temp != null) {
            int num = temp.val;
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                if (newHead == null) {
                    newHead = new ListNode(num);
                    newTemp = newHead;
                } else {
                    newTemp.next = new ListNode(num);
                    newTemp = newTemp.next;
                }
            }
            temp = temp.next;
        }
        return newHead;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode later = null;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (pre != null){
            if (!hashMap.containsKey(pre.val)){
                hashMap.put(pre.val, 1);
                later = pre;
                pre = pre.next;
            } else {
                pre = pre.next;
                later.next = pre;
            }
        }
        return head;
    }
}
