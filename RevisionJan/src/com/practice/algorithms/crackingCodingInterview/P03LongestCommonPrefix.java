package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P03LongestCommonPrefix {

    // using sorting T=> O(m*n*logn) S=> O(m)
    // sort the String array and compare first and last to find prefix
    public static String longestCommonPrefix_Approach2(String[] strs) {
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int i = 0;
        while (i < start.length() && i < end.length() && start.charAt(i) == end.charAt(i)) {
            i++;
        }

        return start.substring(0, i);
    }

    // using word by word comparison
    public static String longestCommonPrefix_Approach1(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int len = commonPrefixLength(res, strs[i]);
            res = res.substring(0, len);
        }
        return res;
    }

    static int commonPrefixLength(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: "
                + "fl".equals(longestCommonPrefix_Approach1(new String[] { "flower", "flow", "flight" }))); // Common
                                                                                                            // prefix:
                                                                                                            // "fl"
        System.out.println(
                "Test Case 2: " + "".equals(longestCommonPrefix_Approach1(new String[] { "dog", "racecar", "car" }))); // No
                                                                                                                       // common
                                                                                                                       // prefix
        System.out.println("Test Case 3: " + "a".equals(longestCommonPrefix_Approach1(new String[] { "a", "a", "a" }))); // Common
                                                                                                                         // prefix:
                                                                                                                         // "a"
        System.out.println("Test Case 4: " + "".equals(longestCommonPrefix_Approach1(new String[] { "", "b", "c" }))); // Empty
                                                                                                                       // prefix
        System.out.println("Test Case 5: "
                + "pre".equals(longestCommonPrefix_Approach1(new String[] { "prefix", "prelude", "present" }))); // Common
                                                                                                                 // prefix:
                                                                                                                 // "pre"
        System.out.println("Test Case 6: " + "".equals(longestCommonPrefix_Approach1(new String[] { "" }))); // Empty
                                                                                                             // array
        System.out.println("Test Case 7: " + "abc".equals(longestCommonPrefix_Approach1(new String[] { "abc" }))); // Single
                                                                                                                   // string
        System.out.println("Test Case 8: " + "".equals(longestCommonPrefix_Approach1(new String[] { "", "" }))); // Both
                                                                                                                 // strings
                                                                                                                 // are
                                                                                                                 // empty
        System.out.println("Test Case 9: " + "hello".equals(longestCommonPrefix_Approach1(new String[] { "hello" }))); // Single
                                                                                                                       // string:
                                                                                                                       // "hello"
        System.out
                .println("Test Case 10: " + "".equals(longestCommonPrefix_Approach1(new String[] { "abcd", "efgh" }))); // No
                                                                                                                        // common
                                                                                                                        // prefix
    }

}
