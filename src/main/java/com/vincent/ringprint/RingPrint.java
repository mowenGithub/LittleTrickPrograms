package com.vincent.ringprint;

/**
 * Created by Vincent on 5/3/16.
 * 回型旋转打印二维数组
 */
public class RingPrint {

    public static void main(String[] args) {
        char[][] charArray = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}};

        assert "abcfilkjgdeh".equals(circlePrint(charArray));
    }

    private static String circlePrint(char[][] charArray) {
        int i = 0, j = -1; //state 记录方向 i记录二维数组第一维 j记录二维数组第二维
        int nOne = charArray.length;
        int nTwo = charArray[0].length;

        StringBuilder result = new StringBuilder();

        while(true) {
            //right
            for(int ii = 0; ii < nTwo; ii++) {
                j += 1;
                result.append(charArray[i][j]);
            }
            nOne--;
            if(nOne == 0 && nTwo == 0) {
                break;
            }

            //down
            for(int ii = 0; ii < nOne; ii++) {
                i += 1;
                result.append(charArray[i][j]);
            }
            nTwo--;
            if(nOne == 0 && nTwo == 0) {
                break;
            }

            //left
            for(int ii = 0; ii < nTwo; ii++) {
                j -= 1;
                result.append(charArray[i][j]);
            }
            nOne--;
            if(nOne == 0 && nTwo == 0) {
                break;
            }

            //up
            for(int ii = 0; ii < nOne; ii++) {
                i -= 1;
                result.append(charArray[i][j]);
            }
            nTwo--;
            if(nOne == 0 && nTwo == 0) {
                break;
            }
        }
        return result.toString();
    }
}
