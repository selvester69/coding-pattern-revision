package com.practice.algorithms.crackingCodingInterview;

public class P026ZigZagNumber {

    public static String convert(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }

        int direction = -1, index = 0;
        for (int i = 0; i < s.length(); i++) {
            res[index] = res[index].append(s.charAt(i));
            if (index == 0) {
                direction = -direction;
            }
            if (index == numRows - 1) {
                direction = -direction;
            }
            index = index + direction;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder str : res) {
            ans.append(str);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }

}
