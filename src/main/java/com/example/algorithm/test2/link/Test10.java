package com.example.algorithm.test2.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/7/24 13:26
 */
public class Test10 {
    /**
     * 删除单向链表中间的某个结点，假定你只能访问该结点。
     *
     * 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
     */

    public static void main(String[] args) {
        Test10 test10 = new Test10();

        ListNode a = new ListNode(4);

        ListNode b = new ListNode(5);

        ListNode head = new ListNode(1);
        head.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(a)
                .addNext(b);
        System.out.println(test10.deleteLastNode(a));
    }

    private boolean deleteLastNode(ListNode target) {
        if(target==null||target.next==null){
            return false;
        }
        /**
         * 主要使用的值替换和替代的思想
         *
         * 直接删除本节点是做不到的，因为单向链表，我们不知道前面的结点
         * 目前也只能访问要删除的目标结点
         * 所以将目标结点的一个结点的值覆盖当前节点，然后去掉下一个结点，
         * 来达到删除当前节点的目的
         */
        target.val=target.next.val;
        target.next=target.next.next;
        return true;
    }
}
