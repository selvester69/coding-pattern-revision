package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class LastIndexOfElement {

    public static int lastIndexOf(int[] nums, int x, int index) {
        if (nums == null || index < 0) {
            return -1;
        }
        if (index >= nums.length)
            return - 1;
        if (index == -1)
            return -1;
        if (nums[index] == x)
            return index;

        return lastIndexOf(nums, x, index - 1);
    }

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] singleElementArray = { 5 };
        int[] positiveArray = { 1, 2, 3, 4, 5 };
        int[] negativeArray = { -1, -2, -3, -4, -5 };
        int[] mixedArray = { -1, 2, -3, 4, -5 };
        int[] duplicateArray = { 1, 2, 2, 4, 5 };
        int[] arrayWithZero = { 0, 1, 2, 3, 0 };

        System.out.println("Test 1: Empty Array, x = 5 - Expected: -1, Actual: "
                + lastIndexOf(emptyArray, 5, emptyArray.length - 1));
        System.out.println("Test 2: Single Element Array, x = 5 - Expected: 0, Actual: "
                + lastIndexOf(singleElementArray, 5, singleElementArray.length - 1));
        System.out.println("Test 3: Single Element Array, x = 10 - Expected: -1, Actual: "
                + lastIndexOf(singleElementArray, 10, singleElementArray.length - 1));
        System.out.println("Test 4: Positive Array, x = 3 - Expected: 2, Actual: "
                + lastIndexOf(positiveArray, 3, positiveArray.length - 1));
        System.out.println("Test 5: Positive Array, x = 6 - Expected: -1, Actual: "
                + lastIndexOf(positiveArray, 6, positiveArray.length - 1));
        System.out.println("Test 6: Negative Array, x = -3 - Expected: 2, Actual: "
                + lastIndexOf(negativeArray, -3, negativeArray.length - 1));
        System.out.println("Test 7: Negative Array, x = 3 - Expected: -1, Actual: "
                + lastIndexOf(negativeArray, 3, negativeArray.length - 1));
        System.out.println("Test 8: Mixed Array, x = 2 - Expected: 1, Actual: "
                + lastIndexOf(mixedArray, 2, mixedArray.length - 1));
        System.out.println("Test 9: Mixed Array, x = -5 - Expected: 4, Actual: "
                + lastIndexOf(mixedArray, -5, mixedArray.length - 1));
        System.out.println("Test 10: Mixed Array, x = 0 - Expected: -1, Actual: "
                + lastIndexOf(mixedArray, 0, mixedArray.length - 1));
        System.out.println("Test 11: Duplicate Array, x = 2 - Expected: 2, Actual: "
                + lastIndexOf(duplicateArray, 2, duplicateArray.length - 1)); // Returns *last* index
        System.out.println("Test 12: Array with zero, x = 0 - Expected: 4, Actual: "
                + lastIndexOf(arrayWithZero, 0, arrayWithZero.length - 1));
        System.out.println("Test 13: Null Array - Expected: -1, Actual: " + lastIndexOf(null, 5, 0));
        System.out.println(
                "Test 14: Index 10 for positive array - Expected: -1, Actual: " + lastIndexOf(positiveArray, 5, 10)); // Index
                                                                                                                      // out
                                                                                                                      // of
                                                                                                                      // bound
        System.out.println(
                "Test 15: Index -1 for positive array - Expected: -1, Actual: " + lastIndexOf(positiveArray, 5, -1)); // Index
                                                                                                                      // is
                                                                                                                      // negative

    }

}
