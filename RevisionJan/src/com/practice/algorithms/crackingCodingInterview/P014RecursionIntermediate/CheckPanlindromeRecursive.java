package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class CheckPanlindromeRecursive {

    public static boolean isPalindrome(int[] nums, int s, int e) {
        if (nums == null)
            return false;
        if (s > e)
            return true;
        if (nums[s] != nums[e]) {
            return false;
        }
        return isPalindrome(nums, s + 1, e - 1);
    }

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] singleElementArray = { 5 };
        int[] palindromeArray1 = { 1, 2, 3, 2, 1 };
        int[] palindromeArray2 = { 1, 2, 2, 1 };
        int[] nonPalindromeArray1 = { 1, 2, 3, 4, 5 };
        int[] nonPalindromeArray2 = { 1, 2, 3, 2, 4 };
        int[] negativePalindrome = { -1, -2, -2, -1 };
        int[] negativeNonPalindrome = { -1, -2, -3, -1 };

        System.out.println("Test 1: Empty Array - Expected: true, Actual: " + isPalindrome(emptyArray, 0, -1)); // Corrected
                                                                                                                // indexes
        System.out.println(
                "Test 2: Single Element Array - Expected: true, Actual: " + isPalindrome(singleElementArray, 0, 0));
        System.out.println("Test 3: Palindrome Array 1 - Expected: true, Actual: "
                + isPalindrome(palindromeArray1, 0, palindromeArray1.length - 1));
        System.out.println("Test 4: Palindrome Array 2 - Expected: true, Actual: "
                + isPalindrome(palindromeArray2, 0, palindromeArray2.length - 1));
        System.out.println("Test 5: Non-Palindrome Array 1 - Expected: false, Actual: "
                + isPalindrome(nonPalindromeArray1, 0, nonPalindromeArray1.length - 1));
        System.out.println("Test 6: Non-Palindrome Array 2 - Expected: false, Actual: "
                + isPalindrome(nonPalindromeArray2, 0, nonPalindromeArray2.length - 1));
        System.out.println("Test 7: Negative Palindrome - Expected: true, Actual: "
                + isPalindrome(negativePalindrome, 0, negativePalindrome.length - 1));
        System.out.println("Test 8: Negative Non-Palindrome - Expected: false, Actual: "
                + isPalindrome(negativeNonPalindrome, 0, negativeNonPalindrome.length - 1));
        System.out.println("Test 9: Null Array - Expected: false, Actual: " + isPalindrome(null, 0, 0));
        System.out.println(
                "Test 10: One element palindrome - Expected: true, Actual: " + isPalindrome(new int[] { 1 }, 0, 0));
        System.out.println(
                "Test 11: s>e but not empty - Expected: true, Actual: " + isPalindrome(palindromeArray2, 2, 1));

    }

}
