package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class CountDigitsRecursively {

    public static int count(int n) {
        // base case
        if (n == 0)
            return 0;

        // recursive case
        int ans = count(n / 10);

        // calculation
        return 1 + ans;
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (count(0) == 0)); // Single digit, count = 1
        System.out.println("Test Case 2: " + (count(5) == 1)); // Single digit number
        System.out.println("Test Case 3: " + (count(123) == 3)); // Three-digit number
        System.out.println("Test Case 4: " + (count(4567) == 4)); // Four-digit number
        System.out.println("Test Case 5: " + (count(789012) == 6)); // Six-digit number
        System.out.println("Test Case 6: " + (count(10000) == 5)); // Leading zero in the number
        System.out.println("Test Case 7: " + (count(1001) == 4)); // Four digits with leading zeros
        System.out.println("Test Case 8: " + (count(99999) == 5)); // All nines number
    }

}
