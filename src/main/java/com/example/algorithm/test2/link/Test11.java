package com.example.algorithm.test2.link;

import com.example.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/7/24 13:40
 */
public class Test11 {

    /**
     *以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
     *
     * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
     * 注意：分割以后保持原来的数据顺序不变。
     */

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        /**
         * 链表顺序
         * 9->14->6->7->2->12->8->4->13->5->10->3
         *
         * 我们以7 为基准
         *
         * 6->2->4->5->3->9->14->7->12->8->13->10
         */
        ListNode head = new ListNode(9);
        head.addNext(new ListNode(14))
                .addNext(new ListNode(6))
                .addNext(new ListNode(7))
                .addNext(new ListNode(2))
                .addNext(new ListNode(12))
                .addNext(new ListNode(8))
                .addNext(new ListNode(4))
                .addNext(new ListNode(13))
                .addNext(new ListNode(5))
                .addNext(new ListNode(10))
                .addNext(new ListNode(3));

        ListNode result = test11.sliceLink1(head, 7);
        System.out.println(result.toString());

    }

    private ListNode sliceLink(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        ListNode maxHead = null;
        ListNode maxCurrent = null;
        ListNode minHead = null;
        ListNode minCurrent = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            if (temp.val >= target) {
                if (maxCurrent == null) {
                    maxCurrent = node;
                    maxHead = node;
                } else {
                    maxCurrent.next = node;
                    maxCurrent = node;
                }
            } else {
                if (minCurrent == null) {
                    minCurrent = node;
                    minHead = node;
                } else {
                    minCurrent.next = node;
                    minCurrent = node;
                }
            }
            temp = temp.next;
        }
        /**
         * 结果3中情况，全大，全小，一半一半
         */
        ListNode resultHead = null;
        if (minCurrent != null && maxHead != null) {
            minCurrent.next = maxHead;
        }
        if (minHead != null) {
            resultHead = minHead;
        } else {
            resultHead = maxHead;
        }
        return resultHead;
    }

    /**
     * 上面的判断太多，进行优化
     * 1.减少判断
     * 2.只改变原来的指针，原俩表的结构破坏忽略
     * 直接将节点加入新的2个链表中
     */
    private ListNode sliceLink1(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode smallCurrent = smallHead;
        ListNode bigCurrent = bigHead;
        while (head != null) {
            if (head.val >= target) {
                bigCurrent.next = head;
                bigCurrent = bigCurrent.next;
            } else {
                smallCurrent.next = head;
                smallCurrent = smallCurrent.next;
            }
            head = head.next;
        }
        //连接2个链表
        smallCurrent.next = bigHead.next;
        //将最后大的链表next原链表断开
        bigCurrent.next = null;
        return smallHead.next;
    }
}
