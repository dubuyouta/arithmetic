package com.example.arithmetic.collection;

import java.util.Map;

/**
 * @author xiaobao.chen
 * Create at 2020-09-08
 */
public class LruTest {

    public static void main(String[] args) {

        LruLinkedHashMap<String, String> lruLinkedHashMap = new LruLinkedHashMap(5);

        lruLinkedHashMap.put("1", "aaaa");
        lruLinkedHashMap.put("2", "bbbb");
        lruLinkedHashMap.put("3", "cccc");
        lruLinkedHashMap.put("4", "dddd");
        lruLinkedHashMap.put("5", "eeee");

        for (Map.Entry<String, String> entry : lruLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("*******************");

        /**把访问的数据放入到最后面*/
        lruLinkedHashMap.get("4");
        lruLinkedHashMap.get("1");

        for (Map.Entry<String, String> entry : lruLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        /**新增数据时，会触发removeEldestEntry 方法，删除最老的数据*/
        lruLinkedHashMap.put("6", "fffff");
        System.out.println("*******************");

        for (Map.Entry<String, String> entry : lruLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
