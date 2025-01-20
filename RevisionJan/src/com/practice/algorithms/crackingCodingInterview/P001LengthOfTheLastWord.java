package com.practice.algorithms.crackingCodingInterview;

public class P001LengthOfTheLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        s = s.trim();
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }
        return length;

    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (lengthOfLastWord("Hello World") == 5)); // The last word is 'World'
        System.out.println("Test Case 2: " + (lengthOfLastWord("LeetCode") == 8)); // The last word is 'LeetCode'
        System.out.println("Test Case 3: " + (lengthOfLastWord("   fly me   to   the moon  ") == 4)); // 'moon'
        System.out.println("Test Case 4: " + (lengthOfLastWord("a") == 1)); // Single letter word
        System.out.println("Test Case 5: " + (lengthOfLastWord(" ") == 0)); // Only spaces
        System.out.println("Test Case 6: " + (lengthOfLastWord("") == 0)); // Empty string
        System.out.println("Test Case 7: " + (lengthOfLastWord("day ") == 3)); // Ends with space
        System.out.println("Test Case 8: " + (lengthOfLastWord("Hello     ") == 5)); // Multiple trailing spaces
        System.out.println("Test Case 9: " + (lengthOfLastWord("   ") == 0)); // Only spaces
        System.out.println("Test Case 10: " + (lengthOfLastWord(null) == 0)); // Null input
    }
}
