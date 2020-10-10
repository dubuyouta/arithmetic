package com.example.algorithm.test1.link;

import com.alibaba.fastjson.JSON;
import com.example.algorithm.bo.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Test3 {
    /**
     * 题目描述 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */

    public static void main(String[] args) {
        Test3 test = new Test3();
        ListNode listNode = new ListNode(1);
        listNode.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6));
        System.out.println(listNode.toString());
        System.out.println();
        System.out.println(JSON.toJSONString(test.printListFromTailToHead3(listNode)));
    }

    /**
     * 先做列表反转，再顺序输出
     * 这道题目，可以做链表反转
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode pre = null;
        ListNode currentNode = listNode;
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
        /**
         * 第二个错误，此处 应该返回 pre 才是真正的反转链表，
         * currentNode 为last，所以为 null
         */
        System.out.println(currentNode);
        System.out.println(pre.toString());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode temp=pre;
        while (temp!= null) {
            arrayList.add(temp.val);
            temp = temp.next;
        }
        return arrayList;
    }

    /**
     * 利用 ArrayList 每次从第0个位置，开始添加元素,
     * list.add(0,tmp.val);  这样最开始添加的元素就到最后面
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    /**
     * 利用系统栈数据结构
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

