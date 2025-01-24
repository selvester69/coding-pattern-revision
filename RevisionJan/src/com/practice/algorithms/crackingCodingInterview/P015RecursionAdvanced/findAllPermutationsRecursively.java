package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findAllPermutationsRecursively {

    public static void recursiveFindPermutation(String input, int index) {
        // base case
        if (input.length() == 0 || index == input.length()) {
            System.out.println(input);
            return;
        }
        for (int i = index; i < input.length(); i++) {
            input = swap(input, index, i);
            recursiveFindPermutation(input, index + 1);
            input = swap(input, index, i);
        }
    }

    public static String swap(String input, int i, int j) {
        StringBuilder sb = new StringBuilder(input);
        if (i >= 0 && i < input.length() && j >= 0 && j < input.length()) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        testPermutations("", new String[] { "" });
        testPermutations("a", new String[] { "a" });
        testPermutations("ab", new String[] { "ab", "ba" });
        testPermutations("abc", new String[] { "abc", "acb", "bac", "bca", "cab", "cba" });
        testPermutations("aab", new String[] { "aab", "aba", "baa" });
        testPermutations("abcd",
                new String[] { "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc", "bcad", "bcda", "bdac",
                        "bdca", "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab",
                        "dcba" });
    }

    public static void testPermutations(String input, String[] expected) {

        // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(outContent));

        recursiveFindPermutation(input, 0);

        // String[] actualLines = outContent.toString().trim().split("\\r?\\n");
        // Set<String> actualSet = new HashSet<>(Arrays.asList(actualLines));
        Set<String> expectedSet = new HashSet<>(Arrays.asList(expected));

        System.out.println("Input: \"" + input + "\"");
        System.out.println("Expected: " + expectedSet);
        // System.out.println("Actual: " + actualSet);

        // if (actualSet.equals(expectedSet)) {
        // System.out.println("Test Passed");
        // } else {
        // System.out.println("Test Failed");
        // }
        System.out.println("--------------------");
        System.setOut(System.out); // Restore original System.out
    }
}
