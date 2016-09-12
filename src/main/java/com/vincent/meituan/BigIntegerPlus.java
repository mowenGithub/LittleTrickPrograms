package com.vincent.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vincent on 16-9-12.
 * 美团校招 大前端 笔试题  2016.09.12
 * 请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回"error"。
 * 输入为一行，包含两个字符串，逗号分隔，字符串的长度在[1,100]。输出为一行
 * <p>
 * ps:出的题太烂了，至少应该有示例，并且把有'-'号开头算是'error'还是合法负数给标明  这里简单起见认为是'error'
 */
public class BigIntegerPlus {

    private static final String ERROR = "error";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputStr = s.nextLine();

        if (inputStr == null || !inputStr.contains(",")) {
            System.out.println(ERROR);
            return;
        }

        String[] inputStrs = inputStr.split(",");

        if (inputStrs.length != 2) {
            System.out.println(ERROR);
            return;
        }

        System.out.println(onPlus(inputStrs[0].trim(), inputStrs[1].trim()));
    }

    private static String onPlus(String arg1, String arg2) {
        if (!onVerify(arg1) || !onVerify(arg2)) {
            return ERROR;
        }

        int addNumber = 0;  //进位值

        char[] arg1s = arg1.toCharArray();
        char[] arg2s = arg2.toCharArray();

        int arg1Size = arg1s.length;
        int arg2Size = arg2s.length;

        List<Integer> result = new ArrayList<>();
        int x = 0;
        int y = 0;
        try {

            for (int i = 1; i <= (arg1Size > arg2Size ? arg1Size : arg2Size); i++) {
                if (arg1Size >= i) {
                    x = Integer.parseInt(String.valueOf(arg1s[arg1Size - i]));
                } else {
                    x = 0;
                }

                if (arg2Size >= i) {
                    y = Integer.parseInt(String.valueOf(arg2s[arg2Size - i]));
                } else {
                    y = 0;
                }

                int temp = x + y + addNumber;
                addNumber = temp / 10;
                result.add(temp % 10);
            }
            Collections.reverse(result);

            StringBuilder res = new StringBuilder();

            for (Integer i : result) {
                res.append(i);
            }
            return res.toString();
        } catch (Exception e) {
            return ERROR;
        }

    }

    private static boolean onVerify(String arg) {
        return arg != null && arg.length() > 0 && arg.length() <= 100;
    }
}
