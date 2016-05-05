package com.vincent.containstr;

/**
 * Created by Vincent on 5/5/16.
 * 判断长字符串A中是否完全包括字符串B中的字符，无顺序要求
 * eg: A: mnqop  B: nmr  false
 *     A: mnqop  B: nmp  true
 */
public class ContainStr {
    public static void main(String[] args) {
        String longStr = "mnqop";
        String shortStrA = "nmr";
        String shortStrB = "nmp";

        char[] longStrArray = longStr.toCharArray();
        char[] shortStrAArray = shortStrA.toCharArray();
        char[] shortStrBArray = shortStrB.toCharArray();

        assert !doubleLoop(longStrArray, shortStrAArray);
        assert doubleLoop(longStrArray, shortStrBArray);

        assert !storeLoop(longStrArray, shortStrAArray);
        assert storeLoop(longStrArray, shortStrBArray);

        assert !primeMul(longStrArray, shortStrAArray);
        assert primeMul(longStrArray, shortStrBArray);
    }

    /**
     * 双循环遍历 时间复杂度O(m*n)
     * @param longStrArray
     * @param shortArray
     * @return
     */
    private static boolean doubleLoop(char[] longStrArray, char[] shortArray) {
        boolean flag = false;
        for(int i = 0; i < shortArray.length; i++) {
            for (int j = 0; j < longStrArray.length; j++) {
                if(shortArray[i] == longStrArray[j]) {
                    flag = true;
                }
            }
            if(flag) {
                flag = false;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 基数存储或hash存储后再获取验证 时间复杂度O(m + n)
     * @param longStrArray
     * @param shortArray
     * @return
     */
    private static boolean storeLoop(char[] longStrArray, char[] shortArray) {
        int[] storeArray = new int[127];
        for(char c : longStrArray) {
            storeArray[c] = 1;
        }
        for(char c : shortArray) {
            if(storeArray[c] != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用素数代表字符，相乘再取模的方式， 巧妙有趣 但 时间复杂度还是O(m + n)
     * @param longStrArray
     * @param shortArray
     * @return
     */
    private static boolean primeMul(char[] longStrArray, char[] shortArray) {
        int[] storeArray = new int[127];
        storeArray['m'] = 3;
        storeArray['n'] = 5;
        storeArray['q'] = 7;
        storeArray['o'] = 11;
        storeArray['p'] = 13;
        storeArray['r'] = 17;
        //int[] storeArray = new int[] {3, 5, 7, 11, 13,...}

        long result = 1;  //should consider the size
        for(char c : longStrArray) {
            result *= storeArray[c];
        }

        for(char c : shortArray) {
            if(result % storeArray[c] != 0) {
                return false;
            }
        }
        return true;
    }
}
