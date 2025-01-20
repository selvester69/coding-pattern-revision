package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class RecursiveMultiplication {

    public static int multiply(int m, int n) {
        // base case
        if (n == 0)
            return 0;

        // recursive case
        int ans = multiply(m, n - 1);

        // calcualtion
        return ans + m;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (multiply(2, 3) == 6)); // 2 * 3 = 6
        System.out.println("Test Case 2: " + (multiply(5, 4) == 20)); // 5 * 4 = 20
        System.out.println("Test Case 3: " + (multiply(7, 1) == 7)); // 7 * 1 = 7
        System.out.println("Test Case 4: " + (multiply(3, 0) == 0)); // 3 * 0 = 0
        System.out.println("Test Case 5: " + (multiply(10, 5) == 50)); // 10 * 5 = 50
        System.out.println("Test Case 6: " + (multiply(1, 10) == 10)); // 1 * 10 = 10
        System.out.println("Test Case 7: " + (multiply(6, 6) == 36)); // 6 * 6 = 36
        System.out.println("Test Case 8: " + (multiply(9, 9) == 81)); // 9 * 9 = 81
    }

}
