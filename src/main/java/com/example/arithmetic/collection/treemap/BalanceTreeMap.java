package com.example.arithmetic.collection.treemap;


import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 利用treeMap 实现一致性hash.
 * 一致性hash 致力于解决集群中动态变化时对整体集群的影响。
 *
 * @author xiaobao.chen
 * Create at 2020-09-08
 */
public class BalanceTreeMap {

    private static TreeMap<String, String> nodeMap = new TreeMap<>();

    private static void addNode(String node) {
        nodeMap.put(String.valueOf(getHash(node)), node);
    }

    private static void deleteNode(String node) {
        nodeMap.remove(String.valueOf(getHash(node)));
    }

    private static int getHash(String str) {

        final int p = 16777619;

        int hash = (int) 2166136261L;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }

        hash += hash << 13;

        hash ^= hash >> 7;

        hash += hash << 3;

        hash ^= hash >> 17;

        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }

        return hash;
    }

    private static void put(String key) {
        String hashCode = String.valueOf(getHash(key));
        SortedMap<String, String> tailMap = nodeMap.tailMap(hashCode);
        String ipKey = tailMap.isEmpty() ? nodeMap.firstKey() : tailMap.firstKey();
        System.out.println(nodeMap.get(ipKey));
    }

    public static void main(String[] args) {
        addNode("192.168.11.201");
        addNode("192.168.11.205");
        addNode("192.168.11.210");
        addNode("192.168.11.290");
        addNode("192.168.11.24");
        System.out.println(nodeMap);

        put("hello tree map");
        put("hello tree map first");
        put("hello tree map balance");
        put("hello tree map double");
    }
}
