package com.example.arithmetic.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xiaobao.chen
 * Create at 2020-09-08
 */
public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LruLinkedHashMap(int capacity) {
        /**accessOrder:true(默认是false. 是按照插入数据放入的。) 会把最新访问的数据放入到尾部*/
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * linkedhashmap 提供的删除最老的数据。当下面的方法返回true时。
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
