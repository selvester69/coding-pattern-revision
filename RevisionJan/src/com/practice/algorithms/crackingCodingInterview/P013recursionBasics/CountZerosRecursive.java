package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class CountZerosRecursive {

    public static int countZeros(int n) {
        // base case
        if (n == 0)
            return 0;

        // recursive case
        int ans = countZeros(n / 10);

        // calculations
        if (n % 10 == 0) {
            return 1 + ans;
        } else
            return ans;
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (countZeros(0) == 0)); // No zeros
        System.out.println("Test Case 2: " + (countZeros(102030) == 3)); // Three zeros
        System.out.println("Test Case 3: " + (countZeros(400500600) == 6)); // six zeros
        System.out.println("Test Case 4: " + (countZeros(12345) == 0)); // No zeros
        System.out.println("Test Case 5: " + (countZeros(100010001) == 6)); // six zeros
        System.out.println("Test Case 6: " + (countZeros(700700700) == 6)); // six zeros
        System.out.println("Test Case 7: " + (countZeros(987654) == 0)); // No zeros
    }
}
