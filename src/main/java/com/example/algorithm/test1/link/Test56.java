package com.example.algorithm.test1.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/5/27 14:17
 */
public class Test56 {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */

    public static void main(String[] args) {
        Test56 test56 = new Test56();

        ListNode node = new ListNode(5);
        ListNode preHead1 = new ListNode(1);
        preHead1.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(node)
                .addNext(new ListNode(6))
                .addNext(new ListNode(9))
                .addNext(new ListNode(8))
                .addNext(node);
        ListNode result=test56.entryNodeOfLoop(preHead1);
        System.out.println(result==null?"null":result.val);


    }

    /**
     * 快慢指针法，如果快指针追上慢指针就代表又环
     *
     * 链表的头结点 到环入口结点p 之间的距离=a
     * 环入口p 到相遇结点 q 之间的距离=b
     *
     * 相遇结点q 到 环入口结点 p 之间距离=c
     *
     * 快指针到满指针相遇走过的路程 S(f)=a+k(b+c)+b K>=0
     *
     * 满指针到相遇走过的路程： S(s)= a+b
     *
     * 快指针是满指针的2倍，所以 2(a+b)=a+k(b+c)+b
     * a=k(b+c)-b=(k-1)(b+c)+c
     *
     * 其中b+c 等于一个圈 ，所以 a=c
     *
     * 需要获取环入口的结点
     * @param head
     * @return
     */
    private ListNode entryNodeOfLoop(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                //相同，有环追上。
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }
}
