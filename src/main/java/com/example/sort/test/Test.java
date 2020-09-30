package com.example.sort.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    int i=0;

    public static void main(String[] args) {
        Test test=new Test();
        System.out.println(test.num());
        System.out.println(test.i);
        /**
         * return  i++  返回 0
         * return  ++i  返回 1
         */
        int[] array={1,2,3};
        //转换错误
        Arrays.asList(array).stream().forEach(item->{
            System.out.println(Arrays.toString(item));
        });
        List<Integer> s=Arrays.stream(array).boxed().collect(Collectors.toList());
       // System.out.println(JSON.toJSONString(Arrays.asList(array)));
        System.out.println();
        //转换基本数组，不能得到正确流
        Stream.of(array).forEach(item->{
            System.out.println(Arrays.toString(item));
        });
        Arrays.stream(array).boxed().forEach(qw->{
            System.out.println(qw);
        });
    }

    public int num(){
        return i++;
    }
}
