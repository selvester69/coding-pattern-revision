package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P002ReverseString {

    public static void reverseString(char[] s) {
        int begin = 0, end = s.length - 1;
        while (begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Test cases
        char[] test1 = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(test1);
        System.out.println("Test Case 1: " + Arrays.equals(test1, new char[] { 'o', 'l', 'l', 'e', 'h' })); // Reversed
                                                                                                            // string:
                                                                                                            // "olleh"

        char[] test2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(test2);
        System.out.println("Test Case 2: " + Arrays.equals(test2, new char[] { 'h', 'a', 'n', 'n', 'a', 'H' })); // Reversed
                                                                                                                 // string:
                                                                                                                 // "hannaH"

        char[] test3 = { 'a' };
        reverseString(test3);
        System.out.println("Test Case 3: " + Arrays.equals(test3, new char[] { 'a' })); // Single character remains the
                                                                                        // same

        char[] test4 = { 'A', 'B', 'C', 'D' };
        reverseString(test4);
        System.out.println("Test Case 4: " + Arrays.equals(test4, new char[] { 'D', 'C', 'B', 'A' })); // Reversed
                                                                                                       // string: "DCBA"

        char[] test5 = {};
        reverseString(test5);
        System.out.println("Test Case 5: " + Arrays.equals(test5, new char[] {})); // Empty array remains the same

        char[] test6 = { '1', '2', '3', '4', '5' };
        reverseString(test6);
        System.out.println("Test Case 6: " + Arrays.equals(test6, new char[] { '5', '4', '3', '2', '1' })); // Reversed
                                                                                                            // numbers:
                                                                                                            // "54321"
    }

}
