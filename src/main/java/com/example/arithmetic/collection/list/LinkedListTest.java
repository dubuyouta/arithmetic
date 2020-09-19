package com.example.arithmetic.collection.list;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * @author xiaobao.chen
 * Create at 2020-09-08
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("aaaa");
        linkedList.addLast("bbbb");
        linkedList.addLast("cccc");
        System.out.println(JSON.toJSONString(linkedList));

        linkedList.remove("cccc");
        linkedList.get(2);
    }
}
