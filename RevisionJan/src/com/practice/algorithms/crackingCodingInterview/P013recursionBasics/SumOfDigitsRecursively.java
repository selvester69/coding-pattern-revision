package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class SumOfDigitsRecursively {

    public static int sumOfDigits(int n) {
        // base case
        if (n == 0)
            return 0;

        // recursive case
        int digit = sumOfDigits(n / 10);

        // calculations
        return digit + n % 10;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (sumOfDigits(0) == 0)); // Single digit, sum = 0
        System.out.println("Test Case 2: " + (sumOfDigits(123) == 6)); // Sum of digits 1 + 2 + 3 = 6
        System.out.println("Test Case 3: " + (sumOfDigits(4567) == 22)); // Sum of digits 4 + 5 + 6 + 7 = 22
        System.out.println("Test Case 4: " + (sumOfDigits(789012) == 27)); // Sum of digits 7 + 8 + 9 + 0 + 1 + 2 = 27
        System.out.println("Test Case 5: " + (sumOfDigits(1111) == 4)); // Sum of digits 1 + 1 + 1 + 1 = 4
        System.out.println("Test Case 6: " + (sumOfDigits(999) == 27)); // Sum of digits 9 + 9 + 9 = 27
        System.out.println("Test Case 7: " + (sumOfDigits(12345) == 15)); // Sum of digits 1 + 2 + 3 + 4 + 5 = 15
        System.out.println("Test Case 8: " + (sumOfDigits(0) == 0)); // Single zero
    }
}
