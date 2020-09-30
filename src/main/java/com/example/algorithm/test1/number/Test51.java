package com.example.algorithm.test1.number;

import com.alibaba.fastjson.JSON;

/**
 * @author: heshineng
 * @createdBy: 2020/5/25 10:04
 */
public class Test51 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     *
     * 分析：b数组元素的规律
     * b数组的 第i项与元素= A数组除了第i项，元素其他所有元素的乘积
     * 如B[0]= A数组除了第0号元素，剩余元素的乘积
     * B[n-1]= A数据除了第n-1号元素，剩余元素的乘积
     *
     *
     */
    public static void main(String[] args) {
        Test51 test51 = new Test51();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(JSON.toJSONString(test51.getArray(array)));
        System.out.println(JSON.toJSONString(test51.multiply(array)));
    }

    /**
     * 将B[i]向拆成 2个新数组的乘积
     * C[i]=A[0]*...A[i-1]
     * D[i]=A[i+1]*...*A[n-1]
     * 从A[i]项隔开的2部分乘积
     * B[i]=C[i]*D[i]
     *
     * 再分别推出C D 的地推公式
     * C[i]=C[i-1]*A[i-1]
     * D[i]=D[i-1]/A[i-1]
     *
     * 推论：C[0]=1
     *       C[1]=A[0]
     *
     *       D[0]=A[1]*...A[n-1]
     *       D[1]=A[2]*...*A[n-1]
     *       D[n-1]=1
     *       D[n-2]=A[n-1]
     *
     *       D[i]=A[i+1]*D[i+1]
     */
    private int[] getArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int[] result = new int[array.length];
        int cNum = 1, dNum = 1;
        int leftIndex = 0, rightIndex = array.length - 1;
        for (; leftIndex < array.length && rightIndex >= 0; leftIndex++, rightIndex--) {
            //先低位
            if (leftIndex < rightIndex) {
                result[leftIndex] = cNum;
                result[rightIndex] = dNum;
            }else if(leftIndex==rightIndex){
                result[leftIndex]=cNum*dNum;
            }else{
                result[leftIndex]=result[leftIndex]*cNum;
                result[rightIndex]=result[rightIndex]*dNum;
            }
            cNum*=array[leftIndex];
            dNum*=array[rightIndex];
        }
        return result;
    }

    //验证
    private int[] getArray1(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int value=1;
        for(int i=0;i<array.length;i++){
            value*=array[i];
        }
        int[] result = new int[array.length];
        for(int i=0;i<array.length;i++){
            result[i]=value/array[i];
        }
        return result;
    }



    int[] multiply(int[] A) {
        int len = A.length;
        int forword[] = new int[len];
        int backword[] = new int[len];
        int B[] = new int[len];
        forword[0] = 1;
        backword[0] = 1;
        for(int i = 1;i < len; i++){
            forword[i] = A[i - 1]*forword[i-1];
            backword[i] = A[len - i]*backword[i - 1];
        }
        for(int i = 0; i < len; i++){
            B[i] = forword[i] * backword[len - i -1];
        }
        return B;
    }
}
