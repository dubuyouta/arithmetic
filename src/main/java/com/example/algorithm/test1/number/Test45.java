package com.example.algorithm.test1.number;

/**
 * @author: heshineng
 * @createdBy: 2020/5/19 11:32
 */
public class Test45 {

    /**
     * 扑克牌顺子
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
     * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
     * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
     * 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     *
     * 简化题目，请从输入的一个数组中判断能否构成5个一连的顺子，输入的数范围为0-13的整数，
     *           其中0可以表示1~13的任意整数。若能构成顺子，返回true，否则返回false
     */

    public static void main(String[] args) {
        Test45 test45 = new Test45();
        int[] x = {1, 3, 5, 0, 0};
        System.out.println(test45.isContinuous(x));
    }

    /**
     * 思路，数组无重复值，不记录0的个数，
     * 最大值减最小值小于5
     * @param array
     * @return
     */
    private boolean isContinuous(int[] array) {
        if (array == null || array.length < 5) {
            return false;
        }
        //计数器发，记录 0-13的数据出现的个数
        int[] countArray = new int[14];
        int min = array[0], max = array[0];
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            if (index == 0) {
                countArray[index]++;
                continue;
            }
            if (countArray[index] > 0) {
                return false;
            } else {
                countArray[index]++;
            }
            if (min == 0) {
                min = index;
            }
            if (index < min) {
                min = index;
            }
            if (index > max) {
                max = index;
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;


    }
}
