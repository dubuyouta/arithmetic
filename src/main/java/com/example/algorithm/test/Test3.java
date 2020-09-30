package com.example.algorithm.test;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 11:17
 */
public class Test3 {
    /**
     * 异或的规则
     * a^a =0  a的自身异或为0
     * 但 a^b^c^d=0 并不能说明 其中有2对相等的值
     *
     * 但是 其中有2对相等的值，最近结果却是是0，只是上面的特例如：
     * a=4 b=4 c=5 d=5 a^b^c^d=4^4^5^5=0
     * 但还有 14^8^4^2=0
     *
     * 规律 14=8+4+2
     *
     * a^b^c^d=0 如果里面不是2对数据相等时，则其中最大的a=b+c+d
     * 如果里面有相等的数时
     * 大多数成立，但不完全成立
     */
    public static void main(String[] args) {
        System.out.println(14^4^10);//0
        System.out.println(15^7^8);//0
        System.out.println(31^16^15);//0
        System.out.println(31^16^1^9^5);//2 不成立
    }
}
