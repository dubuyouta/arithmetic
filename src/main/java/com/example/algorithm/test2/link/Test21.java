package com.example.algorithm.test2.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/7/31 17:39
 */
public class Test21 {
    /**
     * 链表反转
     */
    public static void main(String[] args) {
        Test21 test21=new Test21();
        ListNode listNode = new ListNode(1);
        listNode.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6));
        System.out.println(test21.revertLink(listNode).toString());
    }

    private ListNode revertLink(ListNode head){
        ListNode pre = null;
        ListNode currentNode = head;
        /**
         * 错误 一  此处应该 判断当前节点不为空
         * currentNode.next != null 错误 ---> currentNode!=null
         */
        while (currentNode != null) {
            /**
             * 第一次完后，有错误
             */
            //先暂存后面的结点
            ListNode last = currentNode.next;
            //当前节点的后一个结点断开，指向前一个结点
            currentNode.next = pre;
            //将当前节点 记录为下一次的前一个结点，下次使用
            pre = currentNode;
            //将当前节点转换为下一个结点，循环移动
            currentNode = last;
        }
        return pre;
    }
}
