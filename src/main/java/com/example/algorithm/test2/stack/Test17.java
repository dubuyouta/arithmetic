package com.example.algorithm.test2.stack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/7/27 15:17
 */
public class Test17 {
    /**
     * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
     * 第一种为直接收养所有动物中最早进入收容所的，
     * 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
     *
     *  给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
     *  若第一个元素为1，则代表有动物进入收容所，
     *  第二个元素为动物的编号，正数代表狗，负数代表猫；
     *
     *  若第一个元素为2，则代表有人收养动物，
     *  第二个元素若为0，则采取第一种收养方式，
     *  若为1，则指定收养狗，若为-1则指定收养猫。
     *
     *  请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略
     *
     *  题目解析：
     *
     *  使用n列2行的2维数组，代表输入事件
     *  int[i][0] 第一行数字=1 代表收容动物
     *  int[i][1]                       则此时 第二行数字 正数收容狗  负数收容猫
     *
     *
     *  int[i][0] 第一行数字=2 代表人收容动物
     *  int[i][1]                       此时第二行数字 =0 为第一种收养方式（最早进入收容的动物不论猫狗）
     *                                  此时第二行数字 =1 为收养狗  -1=猫
     *
     *  可以使用栈来代表收容所，收容动物代表入栈，人收养动物，代表出栈，最后返回整个栈结构
     *
     *  第一行数字取值={1,2} 第二行数字取值={-1,0,1}
     *  测试样例：
     * [[1,1],[1,-1],[2,0],[2,-1]]
     * 返回：[1,-1]
     */

    public static void main(String[] args) {
        Test17 test17 = new Test17();
        int[][] array = new int[10][2];

        array[0] = new int[]{1, 1};
        array[1] = new int[]{2, -1};
        array[2] = new int[]{2, 0};
        array[3] = new int[]{1, -1};
        array[4] = new int[]{1, 1};
        array[5] = new int[]{1, 1};
        array[6] = new int[]{2, 1};
        array[7] = new int[]{2, -1};
        array[8] = new int[]{1, -1};
        array[9] = new int[]{1, 1};
        System.out.println(JSON.toJSONString(test17.asylum(array)));
    }

    private List<Integer> asylum(int[][] array) {
        if (array == null || array.length == 0 || array[0].length != 2) {
            return null;
        }
        //收容
        List<Integer> input = new ArrayList<>();
        //收养
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i][0]==1){
                //收容动物
                input.add(array[i][1]);
            }else if(array[i][0]==2){
                //人收养动物
                if(array[i][1]==0){
                    //第一种收养动物方式，最早的随机动物
                    for(int j=0;j<input.size();j++){
                        if(input.get(j)!=0){
                            //代表猫或者狗
                            output.add(input.get(j));
                            //置为0，变成非动物，相当于去除
                            input.set(j,0);
                            break;
                        }
                    }
                }else if(array[i][1]==-1){
                    //收养最初的猫
                    for(int j=0;j<input.size();j++){
                        if(input.get(j)<0){
                            //代表猫
                            output.add(input.get(j));
                            //置为0，变成非动物，相当于去除
                            input.set(j,0);
                            break;
                        }
                    }
                }else if(array[i][1]==1){
                    //收养最初的猫
                    for(int j=0;j<input.size();j++){
                        if(input.get(j)>0){
                            //代表猫
                            output.add(input.get(j));
                            //置为0，变成非动物，相当于去除
                            input.set(j,0);
                            break;
                        }
                    }
                }
            }
        }
        return output;
    }


}
