package com.example.algorithm.test1.link;

import com.example.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/5/7 16:40
 */
public class Test36 {

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     */

    /**
     * 分析 :从头结点开始找，2个单向链表的第一个公共节点
     * link1 head1->2->3->5->6->9->null
     * link2 head2->4->5->8->5->6->9->null
     *
     * 思路一： 以第一个链表头结点开始为基准，开始以每一个结点做遍历循环
     *          在第二层循环中 ，以第2个链表头结点开始遍历循环比对。
     *          如果对比有一样的值，两个链表都开始自之后遍历比对。
     *
     *          如果之后比对的结果都一一致则是公共结点，否则不是。
     *
     *          从第一个链表之前双选移动的结点的后一个结点开始继续循环
     * @param args
     */
    public static void main(String[] args) {
        Test36 test36 = new Test36();
        ListNode preHead1 = new ListNode(1);
        preHead1.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6))
                .addNext(new ListNode(9));

        ListNode preHead2 = new ListNode(2);
        preHead2.addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(8))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6))
                .addNext(new ListNode(9));

        ListNode resultNode = test36.findFirstCommonNode(preHead1, preHead2);
        System.out.println(resultNode == null ? "null" : resultNode.toString());
    }

//    private ListNode findFirstCommonNode(ListNode preHead1, ListNode preHead2) {
//        if (preHead1 == null || preHead2 == null) {
//            return null;
//        }
//        ListNode resultNode = null;
//        ListNode startNode = preHead1;
//        for (; startNode.next != null; startNode = startNode.next) {
//            ListNode secondNode = preHead2;
//            while (secondNode != null) {
//                if (startNode.val == secondNode.val) {
//                    //双向循环比较后面的node
//                    ListNode tempStartNode = startNode;
//                    ListNode tempSecondNode = secondNode;
//                    for (; ; ) {
//                        tempStartNode = tempStartNode.next;
//                        tempSecondNode = tempSecondNode.next;
//                        if (tempStartNode == null && tempSecondNode == null) {
//                            resultNode = startNode;
//                            return resultNode;
//                        }
//                        if (tempStartNode == null && tempSecondNode != null) {
//                            break;
//                        }
//                        if (tempStartNode != null && tempSecondNode == null) {
//                            break;
//                        }
//                        if (tempStartNode.val != tempSecondNode.val) {
//                            break;
//                        }
//                    }
//
//                }
//                secondNode = secondNode.next;
//            }
//
//        }
//        return null;
//    }

    private ListNode findFirstCommonNode(ListNode preHead1, ListNode preHead2) {
        if (preHead1 == null || preHead2 == null) {
            return null;
        }
        ListNode startNode = preHead1;
        for (; startNode.next != null; startNode = startNode.next) {
            ListNode secondNode = preHead2;
            while (secondNode != null) {
                if (compareLinkNode(startNode, secondNode)) {
                    return startNode;
                }
                secondNode = secondNode.next;
            }

        }
        return null;
    }

    private boolean compareLinkNode(ListNode tempStartNode, ListNode tempSecondNode) {
        if (tempStartNode == null || tempSecondNode == null) {
            return false;
        }
        for (; ; ) {
            if (tempStartNode == null && tempSecondNode != null) {
                break;
            }
            if (tempStartNode != null && tempSecondNode == null) {
                break;
            }
            if (tempStartNode == null && tempSecondNode == null) {
                return true;
            }
            if (tempStartNode.val != tempSecondNode.val) {
                break;
            }
            tempStartNode = tempStartNode.next;
            tempSecondNode = tempSecondNode.next;
        }
        return false;
    }
}
