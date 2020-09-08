package com.example.arithmetic.collection.treemap;

import com.alibaba.fastjson.JSON;

import java.util.TreeMap;

/**
 * treemap：
 * 1.存储的数据格式是键值对。key-value
 * 2.底层采用红黑树作为存储的数据结构
 * 3.实现了sortmap接口，所以插入的数据是有序的、默认按照key的顺序进行存储的。在默认情况下，key不允许为空
 * 如果想按照自定义的顺序存储。需要实现Comparator.
 * 4.如果key已经存在，那么在次put时，直接替换value。
 *
 * @author xiaobao.chen
 * Create at 2020-09-08
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("4", "aaaa");
        treeMap.put("2", "bbbb");
        treeMap.put("3", "cccc");
        treeMap.put("5", "dddd");
        System.out.println(JSON.toJSONString(treeMap));
        treeMap.put("5", "5555");
        System.out.println(JSON.toJSONString(treeMap));

//        System.out.println(treeMap.get("4"));
//
//        treeMap.remove("4");
//        System.out.println(JSON.toJSONString(treeMap));

        System.out.println(treeMap.tailMap("4"));
    }
}
