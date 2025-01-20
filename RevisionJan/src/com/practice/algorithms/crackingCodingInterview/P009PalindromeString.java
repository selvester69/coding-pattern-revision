package com.practice.algorithms.crackingCodingInterview;

public class P009PalindromeString {

    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (isPalindrome("A man, a plan, a canal: Panama") == true)); // Valid
                                                                                                        // palindrome
        System.out.println("Test Case 2: " + (isPalindrome("race a car") == false)); // Not a palindrome
        System.out.println("Test Case 3: " + (isPalindrome("") == true)); // Empty string is a palindrome
        System.out.println("Test Case 4: " + (isPalindrome(" ") == true)); // Single space is a palindrome
        System.out.println("Test Case 5: " + (isPalindrome("a.") == true)); // Single character is a palindrome
        System.out.println("Test Case 6: " + (isPalindrome("ab@a") == true)); // Valid palindrome with special
                                                                              // characters
        System.out.println("Test Case 7: " + (isPalindrome("0P") == false)); // Not a palindrome
        System.out.println("Test Case 8: " + (isPalindrome("Madam") == true)); // Case insensitive palindrome
        System.out.println("Test Case 9: " + (isPalindrome("No lemon, no melon") == true)); // Valid palindrome with
                                                                                            // spaces
        System.out.println("Test Case 10: " + (isPalindrome("Able was I, I saw Elba") == true)); // Valid palindrome
                                                                                                 // with mixed cases and
                                                                                                 // punctuation
    }

}
