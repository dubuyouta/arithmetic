package com.example.arithmetic.collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xiaobao.chen
 * Create at 2020/9/21
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("a");
        list.add("b");
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("first:" + list.get(0));

        list.set(0, "d");

        for (String str : list) {
            System.out.println(str);
        }

        list.remove(0);

        for (String str : list) {
            System.out.println(str);
        }
    }
}
