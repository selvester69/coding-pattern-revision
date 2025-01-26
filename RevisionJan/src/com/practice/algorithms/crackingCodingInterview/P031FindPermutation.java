package com.practice.algorithms.crackingCodingInterview;

//this is a paid question in leetcode 

public class P031FindPermutation {

    public static String findPerm(String s, int n) {
        if (s == null)
            return "";
        if (n <= 0 || s.length() == 0) {
            return "";
        }
        int begin = 1, end = n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                sb.append(begin);
                begin++;
            } else {
                sb.append(end);
                end--;
            }
        }
        sb.append(begin);
        if (n != s.length() - 1) {
            return sb.toString().substring(0, n);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        test("", 0, "");
        test("I", 1, "1");
        test("D", 1, "1");
        test("III", 3, "123");
        test("DDD", 3, "321");
        test("ID", 3, "132");
        test("IDI", 4, "1423");
        test("DI", 3, "312");
        test("DII", 4, "4123");
        test("IIDI", 5, "12534");
        test("I", 0, "");
        test("", 5, "");
        test("IIII", 2, "12");
        test("I", 1, "1");
        test("I", -1, "");
        test(null, 5, "");
    }

    private static void test(String s, int n, String expected) {
        String actual = findPerm(s, n);
        if (actual.equals(expected)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("Input String: " + s);
            System.out.println("Input n: " + n);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        System.out.println("---------------");
    }

}
