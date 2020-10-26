package com.example.arithmetic.interview;

/**
 * https://blog.csdn.net/selection_wang/article/details/79096321?utm_source=blogxgwz9
 *
 * @author xiaobao.chen
 * Create at 2020-10-25
 */
public class Ip {

    public static void main(String[] args) {
        System.out.println(intToIP(12345));

    }

    public static String intToIP(Integer ipInt) {
        StringBuffer ipStr = new StringBuffer();
        ipStr.append((ipInt >> 24) & 255).append(".")        //右移24位与255进行"与（且）"运算，得出IP地址第一位
                .append((ipInt >> 16) & 255).append(".")        //右移16位与255进行"与（且）"运算，得出IP地址第一位
                .append((ipInt >> 8) & 255).append(".")            //右移8位与255进行"与（且）"运算，得出IP地址第一位
                .append(ipInt & 255);                            //与255进行"与（且）"运算，得出IP地址第一位
        return ipStr.toString();
    }
}
