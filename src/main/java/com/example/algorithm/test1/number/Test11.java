package com.example.algorithm.test1.number;

import com.kecies.interview.algorithm.test1.ReadMe;

/**
 * @author: heshineng
 * @createdBy: 2019/11/20 0:11
 */
public class Test11 {
    /**
     * 题目
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     * <p>
     * 主要要利用位运算 ^ | & !
     * <p>
     * 参照 {@link ReadMe}
     * <p>
     * 按位与 & 如果两个相应的二进制位都为1，则该位的结果值为1，否则为0
     * 按位或 | 两个相应的二进制位中只要有一个为1，该位的结果值为1
     * <p>
     * 按位取非 ~  ~是一元运算符，用来对一个二进制数按位取反，即将0变1，将1变成0
     * 按位异或 ^  说明：若参加运算的两个二进制位值相同则为0，否则为1
     *
     * 接着问题的3个思路
     * 每一个都有进一步的优化
     *   思路一：要找一个整数二进制数中1的个数 ，首先考虑 二进制中，1,0代表的含义：
     *
     *              一个二进制 从右往左的 第 n 位 二进制位 为1
     *                  它应该表示为  （2 的n-1 次方） *1  （因为最右的最低位的第一位从0开始 表示 2的0次方 =1）
     *
     *              一个二进制 从右往左的 第 n 位 二进制位 为0
     *                 它应该表示为 2 的n-1 次方 *0  0*任意数为 0 所以为0
     *
     *              一个整数n 如果二进制位为 1011
     *                 则从右到左计算过程为：n= 2^0*1 + 2^1*1 + 2^2*0 + 2^3*1
     *
     *                 结论： 如果二进制位 最右一位（第一位）为0  不论其他位 是0 或者1
     *                        这个n 总是 2 的 （1~n-1）次方 和 0 之和  0在加运算中不起作用
     *
     *                        所以结果 全部都是 2的倍数之和，那这个数n 必然被2整除 为偶数
     *
     *                        如果二进制位 最右一位（第一位）为1  不论其他位 是0 或者1
     *                          在最低位不参与计算之前，它任然是个偶数 ，偶数+最低位1=奇数
     *
     *               则：得出结论是 先不管最低位，其他计算为偶数，有1的数并且是2的很多倍
     *
     *                   如n对2求余 则表示 n= 2^0*1 + 2^1*1 + 2^2*0 + 2^3*1 二进制中每一位
     *                   都对2求余，其他的高位不论是0 或者1 求余均为0
     *                   只有最低位 对 2求余 如果为0 表示最低位2进制位为0 其值也为0
     *                                      如果为1  表示最低位2进制位为1 其值也为1
     *
     *                   如果n%2 余数为1 ，即二进制每一位求余 说明目前最低位为1 ，为0 说明最低位为0
     *
     *                   然后将 n=n/2  继续对2求余
     *                   （为什么除以2 ，因为高位为1，为0 对2求余都为0 无意义。当对n/2
     *                   说明整个2进制位都除以2，这样 2进制位的每一位2的倍数缩小一半，只要这些高位一直在
     *                   高位，除以2，代表的1 任然为1 不会变，但最低位1/2 就变为0,0任然不变
     *                   如果变为0，而且除以2 相当于将这个式子向右移动一位，把原来最低位去掉，原来倒数第2位变成新的最低位）
     *                   确定新的最低位是否于 1  每一次于 1 说明 二进制位中1的位数就要加1
     *
     *
     *    思路2： 二进制位 其他位的0或1 不好确认；但是 最低位为0 或者 为 1 是可以确认的
     *             我们可以让 n与 1做 与运算
     *                1的二进制  0001   最低位为1 高位为都为0
     *                假设n二进制 1010
     *                         & 0001
     *                最后的结果是高位都是 0  如果n低位为1 则最后结果为1  如果 n低位为0，最后结果为0
     *
     *                所以这样就是可以确定n的二进制数最低位 是0还是1 然后确定以后，将n的二进制数 右移一位，
     *
     *                让原来n的倒数第二位，变成倒数第一位，又可以判断
     *                当n的所有位全部右移完，就=0  退出循环的条件
     *
     *     思路3：二进制位 为0或者为1  主要思想使用的是消除1的思想，当n二进制位上的 1 全部被消除，就变成0
     *            我们从最低位开始确定 如 0010
     *              让n 与 n-1  做与运算  n与 n-1  的2进制差别 ：从 右到左第一个 1变成0，如果这一位后面还有0 ，则都变为1
     *              如 n=0101  n-1=0100   n=0 100  n-1=0 011  从这一位变化开始的高位都不变化
     *
     *              最终的结果： n 从右往左的i位 的 1 开始 全部取反 就是新的 n-1
     *
     *              此时 n&(n-1)  最终的结果 0 100 & 0 011  = 0 000   将这个1完美消除掉，
     *
     *              再将 &的结果赋值给 n，不断循环 直到n=0 代表1消除完，循环几次，代表有几个1
     *
     *
     */

    public static void main(String[] args) {
        Test11 test = new Test11();
        //11   0000 1011
        System.out.println(test.numberOf1(11));
        System.out.println(test.numberOf2(11));
    }

    public int numberOf1(int n) {
        int nums = 0;
        while (n > 0) {
            /**
             * n & 1 相当于 n%2 求余
             */
            if ((n % 2) == 1) {
                nums++;
            }
            n = n / 2;
        }
        return nums;
    }

    public int numberOf2(int n) {
        /**
         * 利用 n 与1 与运算
         *
         *  如 0101  0101
         *   & 0000  0001
         *
         *   最终结果 其他高位肯定为0 （因为 必须2个位1，才可能为1 ，下面1的高位都是0）
         *   所以 与运算的结果 只能为1 或者为0
         *
         *   如果=0，说明n目前最低位是0 不为1  如果为1 说明最低位为1
         *
         *   然后 n整体右移一位，继续判断新的最低位（相当于n/2）使用无符号右移，这样可以将负数符号问题处理
         *   循环大n=0为止
         */
        int nums = 0;
        while (n > 0) {
            /**
             * n & 1 相当于 n%2 求余
             */
            if ((n & 1) == 1) {
                nums++;
            }
            n = n >>> 1;
        }
        return nums;
    }

    /**
     *另一种思路
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
     * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
     *
     * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，
     * 它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
     * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，
     * 就可以进行多少次这样的操作。
     */
    public int numberOf3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
