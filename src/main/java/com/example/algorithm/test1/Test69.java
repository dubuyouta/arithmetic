package com.example.algorithm.test1;

/**
 * @author: heshineng
 * @createdBy: 2020/7/9 16:11
 */
public class Test69 {
    /**
     * 贪心算法：
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
     *
     * 输入：输入一个数n，意义见题面。（2 <= n <= 60） 输出？
     * 例：8 -> 18
     *
     * 第一个问题：剪成几段不知道，每一组的数列不知道，但长度之和=n
     *
     * 贪心算法有2个方式，一个是剪得段数必然多，段数多，乘积大
     * 另一个市每一段尽可能大，保证乘积大
     *
     * 但是这个2个条件是冲突，剪得多了，每一段必定小，因为总长是确定的。
     * 所以要均衡2种情况
     * 如果使用动态规划，缩减规模
     *
     * 首先举几个例子 2->[2] 不剪 =2
     * 3->[1,2] X [3]不剪 =3 减2段变小
     * 4->[2,2] [4] =4
     * 5->[2,3]  =6
     *
     * f(n-1)=[k1,k2,k3] (k1<k2<k3)
     * f(n)=[k1+1,k2,k3]
     */

    public static void main(String[] args) {
        Test69 test69 = new Test69();
        System.out.println(test69.matProductAfterCutting_1(7));
    }

    /**
     * 贪婪算法
     *
     * @param length
     * @return
     */
    private  int matProductAfterCutting_2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 当n>=5的时候，尽可能剪长度为3的绳子
        int timeOf3 = length / 3;
        // 当n=4的时候，剪成长度为2的两段
        if (length - timeOf3 * 3 == 1) {
            timeOf3 -= 1;
        }
        // 剪成长度为2的两段
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int) ((Math.pow(3, timeOf3)) * (Math.pow(2, timeOf2)));
    }

    /**
     * 动态规划
     *
     * @param length
     * @return
     */
    private  int matProductAfterCutting_1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 将最优解存储在数组中
        int[] products = new int[length + 1];
        // 数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;

        for (int i = 4; i <= length; i++) {
            max = 0;
            // 求出所有可能的f(j)*f(i-j)并比较出他们的最大值
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];

        return max;
    }
}
