package com.example.arithmetic.javabase.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author xiaobao.chen
 * Create at 2020-07-22
 */
public class TreeMapDemo {

    private static final SortedMap<Integer, String> circle = new TreeMap<Integer, String>();// 存储虚拟节点的hash值到真实节点的映射


    public static void main(String[] args) {

        Map<String, Object> treeMap = new TreeMap<>();
        treeMap.put("orange", 1);
        treeMap.put("apple", 2);
        treeMap.put("pear", 3);


        for (String str : treeMap.keySet()) {

            System.out.println(str);
        }


        circle.firstKey();

        //circle.tailMap();
    }
}
