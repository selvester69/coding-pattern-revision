package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class PowerOfNumber {

    public static int power(int x, int n) {

        // base case
        if (n == 0)
            return 1;

        // recursive case
        int op = power(x, n - 1);

        // calculation
        return x * op;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (power(2, 0) == 1)); // 2^0 = 1
        System.out.println("Test Case 2: " + (power(2, 3) == 8)); // 2^3 = 8
        System.out.println("Test Case 3: " + (power(5, 2) == 25)); // 5^2 = 25
        System.out.println("Test Case 4: " + (power(3, 4) == 81)); // 3^4 = 81
        System.out.println("Test Case 5: " + (power(7, 1) == 7)); // 7^1 = 7
        System.out.println("Test Case 6: " + (power(10, 5) == 100000)); // 10^5 = 100000
        System.out.println("Test Case 7: " + (power(1, 10) == 1)); // 1^10 = 1
        System.out.println("Test Case 8: " + (power(-2, 3) == -8)); // (-2)^3 = -8
        System.out.println("Test Case 9: " + (power(-2, 4) == 16)); // (-2)^4 = 16
        System.out.println("Test Case 10: " + (power(0, 5) == 0)); // 0^5 = 0
    }

}
