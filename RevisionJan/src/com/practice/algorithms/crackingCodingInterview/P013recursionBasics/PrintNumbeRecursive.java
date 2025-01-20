package com.practice.algorithms.crackingCodingInterview.P013recursionBasics;

public class PrintNumbeRecursive {

    public static void print(int n) {
        // base case;
        if (n == 0)
            return;

        // recursive case
        print(n - 1);

        // calculation
        System.out.print(n);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.print("Test Case 1: ");
        print(5); // Expected output: 1, 2, 3, 4, 5
        System.out.println();
        System.out.print("Test Case 2: ");
        print(3); // Expected output: 1, 2, 3
        System.out.println();
        System.out.print("Test Case 3: ");
        print(1); // Expected output: 1
        System.out.println();
        System.out.print("Test Case 4: ");
        print(0); // Expected output: Nothing (Base case where n == 0)
        System.out.println();
        System.out.print("Test Case 5: ");
        print(7); // Expected output: 1, 2, 3, 4, 5, 6, 7
        System.out.println();
        System.out.print("Test Case 6: ");
        print(10); // Expected output: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    }

    

}
