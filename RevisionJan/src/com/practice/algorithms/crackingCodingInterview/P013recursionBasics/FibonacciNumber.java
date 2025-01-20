package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class FibonacciNumber {

    public static int fib(int n) {

        // base case
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        // recursive case
        int op1 = fib(n - 1);
        int op2 = fib(n - 2);

        // calculation
        return op1 + op2;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (fib(0) == 0)); // Fibonacci of 0 is 0
        System.out.println("Test Case 2: " + (fib(1) == 1)); // Fibonacci of 1 is 1
        System.out.println("Test Case 3: " + (fib(2) == 1)); // Fibonacci of 2 is 1
        System.out.println("Test Case 4: " + (fib(3) == 2)); // Fibonacci of 3 is 2
        System.out.println("Test Case 5: " + (fib(4) == 3)); // Fibonacci of 4 is 3
        System.out.println("Test Case 6: " + (fib(5) == 5)); // Fibonacci of 5 is 5
        System.out.println("Test Case 7: " + (fib(6) == 8)); // Fibonacci of 6 is 8
        System.out.println("Test Case 8: " + (fib(10) == 55)); // Fibonacci of 10 is 55
        System.out.println("Test Case 9: " + (fib(15) == 610)); // Fibonacci of 15 is 610
        System.out.println("Test Case 10: " + (fib(20) == 6765)); // Fibonacci of 20 is 6765
    }


}
