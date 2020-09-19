package com.example.arithmetic.collection.list;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @author xiaobao.chen
 * Create at 2020-09-08
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaaa");
        arrayList.add(1, "bbbb");
        arrayList.add(null);
        System.out.println(JSON.toJSONString(arrayList));

        arrayList.remove("aaaa");
    }
}
