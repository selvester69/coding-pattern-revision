package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class CountOccurance {

    public static int countOcc(int[] nums, int x, int index) {
        if (nums == null || index >= nums.length) {
            return 0;

        }
        if (nums[index] == x) {
            return 1 + countOcc(nums, x, index + 1);
        } else
            return countOcc(nums, x, index + 1);
    }
    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] singleElementArray = {5};
        int[] positiveArray = {1, 2, 3, 4, 5};
        int[] negativeArray = {-1, -2, -3, -4, -5};
        int[] mixedArray = {-1, 2, -3, 4, -5};
        int[] duplicateArray = {1, 2, 2, 4, 5, 2};
        int[] arrayWithZero = {0, 1, 2, 3, 0};

        System.out.println("Test 1: Empty Array, x = 5 - Expected: 0, Actual: " + countOcc(emptyArray, 5, 0));
        System.out.println("Test 2: Single Element Array, x = 5 - Expected: 1, Actual: " + countOcc(singleElementArray, 5, 0));
        System.out.println("Test 3: Single Element Array, x = 10 - Expected: 0, Actual: " + countOcc(singleElementArray, 10, 0));
        System.out.println("Test 4: Positive Array, x = 3 - Expected: 1, Actual: " + countOcc(positiveArray, 3, 0));
        System.out.println("Test 5: Positive Array, x = 6 - Expected: 0, Actual: " + countOcc(positiveArray, 6, 0));
        System.out.println("Test 6: Negative Array, x = -3 - Expected: 1, Actual: " + countOcc(negativeArray, -3, 0));
        System.out.println("Test 7: Negative Array, x = 3 - Expected: 0, Actual: " + countOcc(negativeArray, 3, 0));
        System.out.println("Test 8: Mixed Array, x = 2 - Expected: 1, Actual: " + countOcc(mixedArray, 2, 0));
        System.out.println("Test 9: Mixed Array, x = -5 - Expected: 1, Actual: " + countOcc(mixedArray, -5, 0));
        System.out.println("Test 10: Mixed Array, x = 0 - Expected: 0, Actual: " + countOcc(mixedArray, 0, 0));
        System.out.println("Test 11: Duplicate Array, x = 2 - Expected: 3, Actual: " + countOcc(duplicateArray, 2, 0)); // Correctly counts duplicates
        System.out.println("Test 12: Array with zero, x = 0 - Expected: 2, Actual: " + countOcc(arrayWithZero, 0, 0));
        System.out.println("Test 13: Null Array, x = 5 - Expected: 0, Actual: " + countOcc(null, 5, 0));
        System.out.println("Test 14: Positive Array, x = 3, index = 2 - Expected: 1, Actual: " + countOcc(positiveArray, 3, 2)); //Start from index 2
        System.out.println("Test 15: Positive Array, x = 5, index = 5 - Expected: 0, Actual: " + countOcc(positiveArray, 5, 5)); //Start from index out of bound
    }
}
