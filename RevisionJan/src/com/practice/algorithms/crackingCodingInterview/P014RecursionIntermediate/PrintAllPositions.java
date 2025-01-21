package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintAllPositions {

    public static void printPositions(int[] nums, int x, int index) {
        if (nums == null || index < 0)
            return;
        if (index >= nums.length)
            return;
        if (nums[index] == x) {
            System.out.println(index);
        }
        printPositions(nums, x, index + 1);
    }

    public static void main(String[] args) {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int[] emptyArray = {};
        int[] singleElementArray = {5};
        int[] positiveArray = {1, 2, 3, 4, 5};
        int[] negativeArray = {-1, -2, -3, -4, -5};
        int[] mixedArray = {-1, 2, -3, 4, -5};
        int[] duplicateArray = {1, 2, 2, 4, 5};
        int[] arrayWithZero = {0, 1, 2, 3, 0};

        printPositions(emptyArray, 5, 0);
        System.out.println("Test 1: Empty Array, x = 5 - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(singleElementArray, 5, 0);
        System.out.println("Test 2: Single Element Array, x = 5 - Expected: 0, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(singleElementArray, 10, 0);
        System.out.println("Test 3: Single Element Array, x = 10 - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(positiveArray, 3, 0);
        System.out.println("Test 4: Positive Array, x = 3 - Expected: 2, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(positiveArray, 6, 0);
        System.out.println("Test 5: Positive Array, x = 6 - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(negativeArray, -3, 0);
        System.out.println("Test 6: Negative Array, x = -3 - Expected: 2, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(negativeArray, 3, 0);
        System.out.println("Test 7: Negative Array, x = 3 - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(mixedArray, 2, 0);
        System.out.println("Test 8: Mixed Array, x = 2 - Expected: 1, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(mixedArray, -5, 0);
        System.out.println("Test 9: Mixed Array, x = -5 - Expected: 4, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(mixedArray, 0, 0);
        System.out.println("Test 10: Mixed Array, x = 0 - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(duplicateArray, 2, 0);
        System.out.println("Test 11: Duplicate Array, x = 2 - Expected: 1\n2, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(arrayWithZero, 0, 0);
        System.out.println("Test 12: Array with zero, x = 0 - Expected: 0\n4, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(null, 5, 0);
        System.out.println("Test 13: Null Array - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(positiveArray, 5, 2);
        System.out.println("Test 14: Start Index in Middle x = 5 - Expected: 4, Actual: " + outContent.toString().trim());
        outContent.reset();

        printPositions(positiveArray, 5, 5);
        System.out.println("Test 15: Start Index out of bound x = 5 - Expected: , Actual: " + outContent.toString().trim());
        outContent.reset();

    }

}
