package com.example.arithmetic.javabase.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaobao.chen
 * Create at 2020-07-17
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        /**通过默认的构造器 进行初始化
         * 空的数组---DEFAULTCAPACITY_EMPTY_ELEMENTDATA
         *
         * */
        List<String> list = new ArrayList<>();

        list.add("a");

        list.add(1, "b");

        list.get(0);

        list.size();

        list.remove("a");

        list.remove(0);

        /**变成线程安全*/
        List<String> synchronizedList = Collections.synchronizedList(list);
    }
}
