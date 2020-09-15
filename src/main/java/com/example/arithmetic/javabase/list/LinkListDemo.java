package com.example.arithmetic.javabase.list;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author xiaobao.chen
 * Create at 2020-07-17
 */
public class LinkListDemo {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        /**新增一个元素。
         * 默认加到最后。
         * */
        linkedList.add("a");
        linkedList.add("b");
        /**加到头部*/
        linkedList.addFirst("c");
        /**加到尾部*/
        linkedList.addLast("d");

        /**
         * 判断当前的位置 在总长度中间位置的那一侧。
         * 如果小于。从前开始遍历
         * 如果大于等于，从后开始遍历。
         *
         *
         */
        linkedList.get(1);


        Collections.synchronizedList(linkedList);
    }
}
