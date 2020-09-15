package com.example.arithmetic.javabase.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiaobao.chen
 * Create at 2020-07-22
 */
public class TreeMapDemo {

    public static void main(String[] args) {

        Map<String, Object> treeMap = new TreeMap<>();
        treeMap.put("orange", 1);
        treeMap.put("apple", 2);
        treeMap.put("pear", 3);

        for (String str : treeMap.keySet()) {

            System.out.println(str);
        }
    }
}
