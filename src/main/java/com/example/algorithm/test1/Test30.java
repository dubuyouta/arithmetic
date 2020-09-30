package com.example.algorithm.test1;

/**
 * @author: heshineng
 * @createdBy: 2019/11/26 1:50
 */
public class Test30 {
    /**
     * 题目：
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下
     *  1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     *  ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
     *  （从1 到 n 中1出现的次数）。
     *
     *  题目要求 : 是出现 1 的 次数 如 11  算2次1  ，并非是 指 出现 1 的数 出现次数
     */

    public static void main(String[] args) {
        Test30 test = new Test30();

//        int[] array = {432, 441, 458, 439, 420, 497, 466, 413};
//        for (int i = 0; i < array.length; i++) {
//            int m = array[i] & 15;
//            int mod = m > 10 ? m - 10 : m;
//            System.out.println(array[i] + " " + mod + " " + (mod >= 2));
//        }

        System.out.println(test.numberOf1Between1And1(13));
        System.out.println(test.numberOf1Between1And2(13));
        System.out.println(test.numberOf1Between1And3(13));

    }

    /**
     *
     * 先分类讨论 找到规律
     * 首先    f(n)= n= 多少 = f(n)
     *   n代表一位数    f(n=0)=     f(0) =0
     *   n代表两位数   f(0<n<=10)=   f(10) =2
     *   n代表两位数   f(0<n<=20)=   f(20) = f(10)+9 =10
     *   n代表两位数   f(0<n<=30)=   f(30) = f(20) +1 =11
     *                ...
     *   n代表两位数   f(0<n<=100)=  f(100)= f(90) + f(10)
     *
     *   n代表三位数   f(0<n<=200)=  f(200) = f(100) +99
     *
     *   n代表三数    f(0<n<=300)= f(300) = f(200) +99
     *
     *   n代表4位数   f(0<n<=1000) = f(1000) = f(900) + f(100)
     *
     *
     *   这种分类讨论 不好操作
     *
     */

    /**
     *  思路分析
     *  分析n 从 [0,n] 范围 数位上出现1的 数 的个数
     *  假设 我们 知道 n 这个数的组成 如果是5位数 分别 万,千,百,十,个 数字
     *  出现的数字 分别用  a ,b,c,d,e  即 组成的数字为 abcde
     *  如对于 n= 34561  a=3 b=4 c=5 d=6 e=1
     *
     *  所以n 出现 1的数的个数 可以分解
     *  f([0,n])=f([0,e])+ f([0,d]) + f([0,c]) + f([0,b]) + f([0,a])
     *
     *  所以总结：0到个位 出现 1 数字 的次数
     *           0到十位 出现 1 数字 的次数
     *           0到百位 出现 1 数字 的次数
     *           0到千位 出现 1 数字 的次数
     *           0到万位 出现 1 数字 的次数
     *
     *    这些和 相加就是 总数
     *
     *    那如何计算 各个位上 出现 1 的次数
     *
     *    个位 十位 百位 等等 出现 1 的方式都是一样
     *
     *    具体做法 我们需要 将 n 按整数点 分割 高位数 a 和 低位数 b
     *
     *    分别计算 它们在某一位上出现 1 的和
     *    然后按这个规律循环
     *
     *    如何 查找 个位 十位 ... 的循环
     *
     *    以 1 10  100  1000  等为 整除点 就是 可以 按 个位 十位 等循环
     *    都是以10倍递增，并称这个数为数位整除点
     *
     *    举例说明，一百位 求1 的数位举例
     *      n=35456  当求百位的1  就要 以100 为数位整除点
     *               a=n/100=354   b=n%100=56
     *     1.这样就将 n百位出现 1 出现的次数 分解为 a ，b 两部分，分别求出 a，b百位出现1的次数
     *
     *     2.问题 [0,n百位]出现 1 次数和 -> 变成 [0,a]百位出现次数 + [0,b] 百位出现次数
     *
     *     3.当对于b来说，它说的 数位整除数来说（如个位，十位等 此处为百位，即100），它是一个余数
     *     不需要考虑复杂，它是一个普通的数，代表n中真实的数位 如b=56  就是 真 56 ，它比百位数小
     *        当要计算 百位出现的1时 ，b本身不够百位，它自身不够百位，它本身计算百位 出现次数为 0
     *        但是它辅助a 计算百位 出现1的 次数 如何辅助后面再说
     *
     *     4. 当对于a=354 来说 ，求它百位出现 1 的次数 并非是真实把 a当成 354 这个数字，求它 百位 3
     *        出现 1的次数 ，a的来源 是 a=n/100 所以a是高位，他的每一位数都代表 百位数
     *        n的高位 a*100=354*100
     *            所以问题为 a*100=354 000 百位 出现1 次数  ->  354 整个数位 [0,354] 354 个位
     *            4 上出现的1  原因 ： 35400 百位出现的1  必定出现 a的最低位 4 上面出现过的1
     *
     *        （1）此处计算a 就有 2种方式 将 a 再做拆解 递归本身计算 （但每一次都要计算递归就很长）
     *         (2) 直接计算
     *               a=354 个位出现1 的个数  （又因为 个位是按 10进为）
     *               354 个位出现的 1 = a/10+1  为什么加1 因为 当数字越过 350 后，后面还有 351
     *
     *               所以对于n的高位 n=a*100 计算百位 其实是 一个有g个100 相加的结果，
     *               每一个100 都出现这多次百位的1，则 刚才 354个位1  (a/10+1)*100 即要乘以 数位整除点
     *
     *
     *               这样既计算出 a的 出现1的次数
     *
     *               但 a的最低位 为0  说明 a不可能越过 351 ，出现1的次数，与b无关，所以无需考虑 出现次数 a/10 * 100
     *
     *               当 a的最低位 为 1  说明除了a 本身计算的值 (a/10)*100  因为百位为1 所以低位 b 还会出现 b+1次
     *                 因为 b是从 00-56 的数 从0开始，再多加一次  所以总次数 (a/10)*100 + （b+1）
     *                 (351 没有越过352  351 这个100 中只出现 b+1 个数 不够100完整序列)
     *
     *              当 a 的最低位 为上述的 大于等2的数 如 a=354 为 (a/10+1)*100
     *                  （352 已经越过 351 这个完整的100 的为1的数 所以最后再+1 个100的数据）
     *
     *
     *         (3) 总结： 当a的最低位 为 0 (a/10)*100
     *                    当a的最低位为 1  (a/10)*100 + (b+1)
     *                    当a的最低位为 >=2 (a/10+1)*100
     *
     *
     *
     */
    public int numberOf1Between1And1(int n) {
        if (n <= 0) {
            return 0;
        }
        //出现 1 次数的数
        int count = 0;
        //diviver =数位整除点
        for (int diviver = 1; diviver <= n; diviver *= 10) {
            // n的数位高位
            int high = Math.floorDiv(n, diviver);
            //n的低位
            int low = Math.floorMod(n, diviver);
            //判断 n高位的最低位的数 是多少
            int highMod = Math.floorMod(high, 10);
            int currentResult = Math.floorDiv(high, 10);
            if (highMod >= 2) {
                currentResult++;
            }
            currentResult *= diviver;
            if (highMod == 1) {
                currentResult += low + 1;
            }
            count += currentResult;
        }
        return count;
    }

    /**
     * 对于 numberOf1Between1And1 的优化
     * 不需要 精准判断低位的值
     * 当high 最低位 小于2 即 0,1 时= high/10
     * 不需要加1
     * 只有当high 最低位 大于等于2 时= high/10 +1
     *
     * 整个结果使用 一个式子表示 (high+8)/10
     * 当低位>=2  如 542 加8  550 产生了进位效果
     * 当低位 0,1 加的最大值为 9 还是舍弃计算也不用进位
     * @param n
     * @return
     */
    public int numberOf1Between1And2(int n) {
        if (n <= 0) {
            return 0;
        }
        //出现 1 次数的数
        int count = 0;
        //diviver =数位整除点
        for (int diviver = 1; diviver <= n; diviver *= 10) {
            // n的数位高位
            int high = Math.floorDiv(n, diviver);
            //n的低位
            int low = Math.floorMod(n, diviver);
            //判断 n高位的最低位的数 是多少
            int highMod = Math.floorMod(high, 10);
            count = count + Math.floorDiv(high + 8, 10)*diviver + (highMod == 1 ? low + 1 : 0);
        }
        return count;
    }

    // 那字符串 验证结果
    public int numberOf1Between1And3(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char [] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}
