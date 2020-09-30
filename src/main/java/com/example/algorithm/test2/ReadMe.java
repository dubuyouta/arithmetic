package com.example.algorithm.test2;

import com.kecies.interview.algorithm.test2.array.*;
import com.kecies.interview.algorithm.test2.graph.*;
import com.kecies.interview.algorithm.test2.link.*;
import com.kecies.interview.algorithm.test2.matrix.*;
import com.kecies.interview.algorithm.test2.queue.*;
import com.kecies.interview.algorithm.test2.stack.*;
import com.kecies.interview.algorithm.test2.string.*;
import com.kecies.interview.algorithm.test2.thread.*;
import com.kecies.interview.algorithm.test2.tree.*;

/**
 * @author: heshineng
 * @createdBy: 2020/7/16 17:40
 */
public class ReadMe {
    /**
     * test2 下
     * 1.{@link Test1}  请实现一个算法，确定一个字符串的所有字符是否全都不同。
     *  这里我们要求不允许使用额外的存储结构。给定一个string iniString，
     *  请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。
     *  字符串的长度小于等于3000
     *
     *  2.{@link Test2}请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
     *    给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000
     *
     *  3.{@link Test3} 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，
     *  能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。给定一个string stringA
     *  和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000
     *
     *  4.{@link Test4} 请编写一个方法，将字符串中的空格全部替换为“%20”。
     *                 假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，
     *                 同时保证字符串由大小写的英文字母组成。给定一个string iniString 为原始的串，
     *                 以及串的长度 int len, 返回替换后的string
     *
     *  5.{@link Test5} 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     *
     *  6.{@link Test6} 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
     *  比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
     *  给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，
     *  返回一个string，为所求的压缩后或未变化的串
     *
     *  7.{@link Test7} 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，
     *    请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
     *    给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     *
     *  8.{@link Test8} 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
     *     给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵
     *     保证n小于等于300，矩阵中的元素为int范围内。
     *
     *  9.{@link Test9}  请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否
     *     为s1旋转而成，要求只能调用一次检查子串的函数。给定两个字符串s1,s2,
     *     请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
     *
     *  10.{@link Test10}删除单向链表中间的某个结点，假定你只能访问该结点。给定待删除的节点，
     *      请执行删除操作，若该节点为尾节点，返回false，否则返回true
     *
     *  11.{@link Test11}以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
     *     给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
     *      注意：分割以后保持原来的数据顺序不变
     *
     *  12.{@link Test12}有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
     *     也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
     *     给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)
     *
     *  13.{@link Test13}检查链表是否为回文。给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     *
     *  14.{@link Test14}输入一个链表，输出该链表中倒数第k个结点。
     *
     *  15.{@link Test15}请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，
     *     当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作
     *
     *  16.{@link Test16} 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能
     *                    使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
     *
     *  17.{@link Test17} 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
     *                若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，
     *              正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，
     *              第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫
     *
     *  18.{@link Test18} 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，
     *                   其两颗子树的高度差不超过1。给定指向树根结点的指针TreeNode* root，
     *                   请返回一个bool，代表这棵树是否平衡
     *
     *  19.{@link Test19} 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
     *
     *  20.{@link Test20} 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
     *
     * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
     *
     * 21.{@link Test21} 链表反转
     *
     * 22.{@link Test22} 按顺序输出二叉树每一行最大数
     *
     * 23.{@link Test23} 根据前序遍历和中序遍历，构造二叉树，假设无重复数据
     *
     * 24.{@link Test24} 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k
     *                   个字符的前 k 个字符进行反转。
     *
     * 25.{@link Test25} 3个线程交替打印，最后输出abc
     *
     * 26.{@link Test26} 在排序数组中查找元素的第一个和最后一个位置-对二分法查找的改造
     *
     * 27.{@link Test27} 给定一个只包括 '('，')'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
     *
     * 28.{@link Test28} 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     *
     *
     *
     *
     *
     */

}
