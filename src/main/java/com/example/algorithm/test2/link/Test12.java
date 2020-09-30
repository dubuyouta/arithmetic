package com.example.algorithm.test2.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/7/24 15:13
 */
public class Test12 {
    /**
     * 两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
     * 也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
     * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)
     *
     * 测试样例：
     * {1,2,3},{3,2,1}
     * 返回：{4,4,4}
     */

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        /**
         * 4->6->7           764
         * 7->4->2->9       9247
         * 1->1->0->0->1   10011
         */
        ListNode a = new ListNode(4);
        a.addNext(new ListNode(6))
                .addNext(new ListNode(7));

        ListNode b = new ListNode(7);
        b.addNext(new ListNode(4))
                .addNext(new ListNode(2))
                .addNext(new ListNode(9));

        ListNode result = test12.sumLink1(a, b);
        if (result != null) {
            System.out.println(result.toString());
        }
    }

    /**
     * 判断过多，逻辑比较复杂
     * 优化：减少判断
     * @param a
     * @param b
     * @return
     */
    private ListNode sumLink(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode resultHead=a;
        //前一次的进位，不是1，就是0
        /**
         * 前一次进位最多是9+9 +1（前一次进位）
         * 所以当前为最多19
         */
        int preCarryNum=0;
        ListNode preResult=null;
        while (a!=null||b!=null){
            if(a!=null&&b!=null){
                int num=a.val+b.val+preCarryNum;
                a.val=num%10;
                preCarryNum=num/10;
                preResult=a;
                a=a.next;
                b=b.next;
            }else if(a!=null){
                //b==null
                int num=a.val+preCarryNum;
                a.val=num%10;
                preCarryNum=num/10;
                preResult=a;
                a=a.next;
            }else{
                //a==null,b!=null
                int num=b.val+preCarryNum;
                b.val=num%10;
                preCarryNum=num/10;
                /**
                 * preResult 保存 a的最后一个元素
                 * 此时，a=null
                 */
                preResult.next=b;
                preResult=b;
                b=b.next;
            }
        }
        //如果a,b结束，还有进位
        if(preCarryNum==1){
            preResult.next=new ListNode(1);
        }
        return resultHead;
    }

    private ListNode sumLink1(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode resultHead=a;
        ListNode resultPre=null;
        int preCarryNum=0;
        while (a!=null||b!=null){
            int num=preCarryNum;
            num=a!=null?num+a.val:num;
            num=b!=null?num+b.val:num;
            int indexNum=num%10;
            preCarryNum=num/10;
            if(a!=null){
                //a!=null b=null  或 a b 都不为null
                a.val=indexNum;
                resultPre=a;
                a=a.next;
            }

            if(b!=null){
                if(a==null){
                    b.val=indexNum;
                    resultPre.next=b;
                    resultPre=b;
                }
                b=b.next;
            }
        }

        //如果a,b结束，还有进位
        if(preCarryNum==1){
            resultPre.next=new ListNode(1);
        }
        return resultHead;
    }

    /**
     * 不考虑复用原节点的状况，
     * 全部使用新的结点
     */
    private ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode resultHead = new ListNode(-1);
        ListNode resultCurrent = resultHead;
        int addToNextDigit = 0;
        while (a != null || b != null || addToNextDigit != 0) {
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;

            int sum = aVal + bVal + addToNextDigit;
            int nodeDigit = sum % 10;
            addToNextDigit = sum / 10;

            resultCurrent.next = new ListNode(nodeDigit);
            resultCurrent = resultCurrent.next;

            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return resultHead.next;
    }



}
