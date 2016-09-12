package com.vincent.meituan;

import java.util.Scanner;

/**
 * Created by Vincent on 16-9-12.
 * 美团校招 大前端 笔试题  2016.09.12
 * 给你六种面额1, 5, 10, 20, 50, 100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元(N为0~10000的非负整数)的不同组合的个数
 * 输入为一个数字N，输出也是一个数字，为组成N的组合个数
 * <p>
 * 如果是10000，组合数很可能int无法存储
 */
public class Combination {

    private static final String ILLEGAL_INPUT = "ILLEGAL_INPUT";
    private static final int[] BASE_NUMBERS = {100, 50, 20, 10, 5, 1};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();

        try {
            int N = Integer.parseInt(inputStr);

            if (N < 0 || N > 10000) {
                System.out.println(ILLEGAL_INPUT);
                return;
            }

            System.out.println(backPack(N));
            System.out.println(f(0, N));
        } catch (Exception e) {
            System.out.println(ILLEGAL_INPUT);
        }
    }

    /**
     * 背包法  太慢  相当于加法  n^6
     */
    public static int backPack(int N) {
        int result = 0, temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0;
        for (int i = N / BASE_NUMBERS[0]; i >= 0; i--) {
            temp1 = N - i * BASE_NUMBERS[0];
            for (int ii = temp1 / BASE_NUMBERS[1]; ii >= 0; ii--) {
                temp2 = temp1 - ii * BASE_NUMBERS[1];
                for (int iii = temp2 / BASE_NUMBERS[2]; iii >= 0; iii--) {
                    temp3 = temp2 - iii * BASE_NUMBERS[2];
                    for (int iiii = temp3 / BASE_NUMBERS[3]; iiii >= 0; iiii--) {
                        temp4 = temp3 - iiii * BASE_NUMBERS[3];
                        for (int iiiii = temp4 / BASE_NUMBERS[4]; iiiii >= 0; iiiii--) {
                            temp5 = temp4 - iiiii * BASE_NUMBERS[4];
                            if (temp5 % BASE_NUMBERS[5] == 0) {
                                System.out.print(i + "个" + BASE_NUMBERS[0] + " ");
                                System.out.print(ii + "个" + BASE_NUMBERS[1] + " ");
                                System.out.print(iii + "个" + BASE_NUMBERS[2] + " ");
                                System.out.print(iiii + "个" + BASE_NUMBERS[3] + " ");
                                System.out.print(iiiii + "个" + BASE_NUMBERS[4] + " ");
                                System.out.print(temp5 / BASE_NUMBERS[5] + "个" + BASE_NUMBERS[5] + " ");
                                System.out.println("");
                                result++;
                                continue;
                            }
                        }
                    }

                }
            }

        }
        return result;
    }

    /**
     * 下面这种递归 本质还是加法，怎么改进成乘法？
     * @param index 是指该用baseNumbers里面第几个开始算
     * @param last 指现在N还剩多少
     * @return
     */
    private static int f(int index, int last) {
        if (index == 5) {
            return 1;
        }

        int num = last / BASE_NUMBERS[index];

        int total = 0;
        int temp;
        for (int i = 0; i <= num; i++) {
            temp = f(++index, last - i * BASE_NUMBERS[--index]);
            if (temp == 0) {
                temp = 1;
            }
            total += temp;
        }
        return total;
    }
}
