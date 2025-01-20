package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class GeometricSum {

    public static double geometricSum(int k) {

        // base case
        if (k == 0)
            return 1;

        // recursive case
        double ans = geometricSum(k - 1);

        // calculations
        return ans + 1.0 / Math.pow(2, k);
    }

    public static void main(String[] args) {
        System.out.println("Test 1: k = 0 - Expected: 1.0, Actual: " + geometricSum(0));
        System.out.println("Test 2: k = 1 - Expected: 1.5, Actual: " + geometricSum(1));
        System.out.println("Test 3: k = 2 - Expected: 1.75, Actual: " + geometricSum(2));
        System.out.println("Test 4: k = 3 - Expected: 1.875, Actual: " + geometricSum(3));
        System.out.println("Test 5: k = 4 - Expected: 1.9375, Actual: " + geometricSum(4));
        System.out.println("Test 6: k = 10 - Expected: 1.9990234375, Actual: " + geometricSum(10));
        System.out.println("Test 7: k = 20 - Expected: 1.9999990463256836, Actual: " + geometricSum(20));

        // Test for negative input (important edge case)
        try {
            geometricSum(-1);
            System.out.println("Test 8: k = -1 - Expected: IllegalArgumentException, Actual: No Exception Thrown");
        } catch (StackOverflowError e) {
            System.out.println("Test 8: k = -1 - Expected: IllegalArgumentException, Actual: StackOverflowError Thrown (Incorrect Base Case Handling)");
        }
    }

}
