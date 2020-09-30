package com.example.algorithm.test1.number;

/**
 * @author: heshineng
 * @createdBy: 2019/11/21 16:37
 */
public class Test12 {
    /**
     * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     *       保证base和exponent不同时为0
     *
     *       如 base=1.332 exponent=3
     *
     *       总结就是：求 一个小数 的 n 次方
     *       最简单的 base 相乘n次
     *
     *       注意：主要注意 exponent为大于0的数 为负数 为 0
     *
     * 思路二  power2 主要使用快速幂算法
     *       前面判断一致，只是优化最后的数据循环相乘的问题。
     *
     *       与运算符&和移位运算符>>，有人提出了快速幂的算法，其时间复杂度为O(logN)
     *
     *       例如计算ab这样一个数，我们指数b以转换二进制的形式进行分解，将其写成二进制中每一位乘上该位的权重(从右往左，第i位的权为2i-1)。
     *
     *
     *       快速幂运算
     *       实践基础 利用2进制值特性 已经 & 和 >> 的算法
     *
     *       如计算 a 的 13 次方
     *
     *       13的二进制 1101 = 2^0*1 + 2^1*0 + 2^2*1 + 2^3*1 = 2^0 + 2^2 + 2^3 = 1 + 4 + 8
     *
     *       利用数学知识可得：
     *       a的 13 次方  = a的 2^0 次方  *  a的 2^2 的 次方 * a的 2^3
     *
     *       所以对于13=1101 来说 变换成 上式
     *
     *       只要 我们分别 得到 a的 2^0 次方   a的 2^2 的 次方  a的 2^3 再相乘 就是结果
     *
     *       就是依照这个思路来了，我们只需要循环 n 二进制  位 的个数 次 就可以得到结果
     *
     *       利用每次循环，后面的数，均可以利用前面的数算的
     *
     *       如 n=13，int sum=1;
     *          int a=4;
     *       while(n!=0){
     *           if(n&1==1){
     *               sum*=a;
     *           }
     *           a*=a;
     *           n=n>>1;
     *       }
     *       对于 n=15=1111
     *       a 的 15 次方 =1* (a 的 2^0 次方)  *  (a的 2^1 次方) * (a的 2^2 次方)  * (a的 2^3次方)
     *       要计算这个式子，从此2项开始，每次需要用到前2项的乘积 首先第一项为 a的1次方=a
     *
     *       利用2进制特性 分别是 （a 的 1次) (a的2次) （a的4次） (a的 8次)  1,2,4,8
     *
     *       数列{1,2,4,8}的规律 ： 从第2项开始 第n项 等于 f(n)=f(n-1)+f(n-2)+...+f(1)+1
     *                                                   f(n-1)=     f(n2)+....+f(1)+1
     *       所以 每一项f(n)=2*f(n-1)
     *
     *       带入a的2进制方中：
     *
     *       以下特性需要使用到数学知识
     *       int sum=a^15= a 的 (1+2+4+8) 次方
     *                  =(a 的 1次)*(a的2次)*(a的4次)*(a的 8次)
     *                  = (a 的 2^0 次)* (a 的 2^1 次) * (a 的 2^2 次) * (a 的 2^3 次)
     *                  = a(1) * a(2) * a(3) * a(4)
     *
     *                  利用上面特性： a(2)=a的 (2^1) 次 =a 的 (2^0+1) 次 = a的 (2^0) 次 * a
     *                                    = a(1)*a
     *
     *                                a(3)=a的 (2^1+2^0+1) 次 =a的(2^1)次  * a的(2^0)次 * a
     *                                    =a(2)*a(1)*a
     *
     *                 a(n)= a(n-1)*a(n-2)*...*a(1)*a
     *                 a(n-1)=      a(n-2)*...*a(1)*a
     *
     *                 a(n)=a(n-1)*a(n-1)= a(n-1) 的平方
     *
     *              所以上例 是一种特例 每一个2进制位1 =a^15 = a(1)*a(2)*a(3)*a(4);
     *                                                       其中 a(4)=a*a(1)*a(2)*a(3)
     *
     *              所以参照 fastpower1 使用2个指针 记录
     *                 一个是前一个 所有项乘积用来计算下一次an
     *                 一个 用来 把每次计算的an 乘起来
     *
     *
     *
     *           另一个特性的想法：
     *             int sum= (a 的 2^0 次)* (a 的 2^1 次) * (a 的 2^2 次) * (a 的 2^3 次)
     *                    = a(1) * a(2) * a(3) * a(4)
     *
     *                    每次循环通过base扩大2倍，得到下一个值
     *
     *                    每次循环 扩大 幂乘次
     *                    a(0) =1
     *                    a(0) -> a(1) 需要乘以 base=a
     *                    a(0) -> a(2) 需要乘以 base=base*base =a 的 2 次方
     *                    a(0) -> a(3) 需要乘以 base=base*base =a 的 4 次方
     *                    a(0) -> a(4) 需要乘以 base=base*base =a^4*a^4=a^8=(a 的 2^3 次)
     *
     *                    每次循环都是为了确定下一项
     *
     *                    参照 fastPower
     */

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        System.out.println(test12.power2(2.1d, 2));
        System.out.println(test12.power2(2.1d, -2));
        System.out.println(test12.power2(-2.1d, 2));
        System.out.println(test12.power2(-2.1d, -2));

        System.out.println();
        System.out.println(test12.power3(2.1d, 2));
        System.out.println(test12.power3(2.1d, -2));
        System.out.println(test12.power3(-2.1d, 2));
        System.out.println(test12.power3(-2.1d, -2));

        System.out.println(test12.fastPower1(2, 6));

    }


    /**
     * 问题，没有考虑所有情况 base 和 exponent均有可能为负数
     * @param base
     * @param exponent
     * @return
     */
    public double power1(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 数学知识 一个数的负数次方 =这个数整数次方的倒数
     *
     * 如： 3 的 -2 次方 = 3 的 2次方 的倒数  即 1/9
     *
     * 进化版 base 和 exponent 均有可萌为负数 和 0
     * @param base
     * @param exponent
     * @return
     */
    public double power2(double base, int exponent) {
        if (base == 0 && exponent <= 0) {
            throw new RuntimeException();
        }
        if (base != 0 && exponent == 0) {
            return 1;
        }
        int n = exponent > 0 ? exponent : -exponent;
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }

    /**
     * 快速幂运算
     * 实践基础 利用2进制值特性 已经 & 和 >> 的算法
     *
     * @param base
     * @param exponent
     * @return
     */
    int fastPower(int base, int exponent) {
        int result = 1;
        int an = base; //(an 从最低位开始,代表式子的每一项 第一项 a(1)= a 的 2^0 次方)
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                //当前最低位有值，将 an 乘入结果中保存
                result *= an;
            }
            exponent = exponent >> 1;
            an *= an;
        }
        return result;
    }

    /**
     * 自己思路完成的快速
     *
     * preResult存储 = a(1)*a(2)*...a(n-1)
     * a(n)=preResult存储*a
     *
     * realResult=realResult*a(n)
     *
     * @param base
     * @param exponent
     * @return
     */
    int fastPower1(int base, int exponent) {
        //后一项用于等于 前几项的乘积 再乘以 base
        //计算 an的结果
        int preResult = 1;
        int realResult = 1;
        //以得到an目的为主
        while (exponent != 0) {
            int an = preResult * base;//得到 a1
            preResult = an * preResult;// 用于计算 下次 an
            if ((exponent & 1) == 1) {
                realResult = realResult * an;
            }
            exponent = exponent >> 1;
        }
        return realResult;
    }


    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double power3(double base, int exponent) {

        if (base == 0 && exponent <= 0) {
            throw new RuntimeException();
        }
        if (base != 0 && exponent == 0) {
            return 1;
        }
        int n = exponent > 0 ? exponent : -exponent;
        double result = 1;
        double an = base;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= an;
            }
            n = n >> 1;
            //下一位 an 的数
            an *= an;
        }
        return exponent > 0 ? result : 1 / result;
    }
}
