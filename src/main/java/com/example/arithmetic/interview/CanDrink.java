package com.example.arithmetic.interview;

/**
 * @author xiaobao.chen
 * Create at 2020-10-21
 */
public class CanDrink {

    public static void main(String[] args) {
        System.out.println(canDrink(20, 0, 0, 0));
    }

    /**
     * @param money 总金额
     * @param bottle_num 瓶身
     * @param bottle_top_num 瓶盖
     * @return
     */
    public static int canDrink(int money, int bottle_num, int bottle_top_num, int can) {
        if (money <= 0 && bottle_num < 2 && bottle_top_num < 3) {
            return can;
        }else {
            if (money > 0) {
                can++;
                return canDrink(money - 1, bottle_num + 1, bottle_top_num + 1, can);
            }

            if (bottle_num >= 2) {
                can++;
                return canDrink(money, bottle_num - 2 + 1, bottle_top_num + 1, can);
            }

            if (bottle_top_num >= 3) {
                can++;
                return canDrink(money, bottle_num + 1, bottle_top_num - 3 + 1, can);
            }
            return can;
        }

    }
}
