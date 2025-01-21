package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class FirstIndexOfElement {

    public static int firstIndex(int[] nums, int x, int index) {
        // base
        if (nums == null)
            return -1;
        if (index >= nums.length)
            return -1;
        if (nums[index] == x)
            return index;

        return firstIndex(nums, x, index + 1);
    }

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] singleElementArray = { 5 };
        int[] positiveArray = { 1, 2, 3, 4, 5 };
        int[] negativeArray = { -1, -2, -3, -4, -5 };
        int[] mixedArray = { -1, 2, -3, 4, -5 };
        int[] duplicateArray = { 1, 2, 2, 4, 5 };

        System.out.println("Test 1: Empty Array, x = 5 - Expected: -1, Actual: " + firstIndex(emptyArray, 5, 0));
        System.out.println(
                "Test 2: Single Element Array, x = 5 - Expected: 0, Actual: " + firstIndex(singleElementArray, 5, 0));
        System.out.println("Test 3: Single Element Array, x = 10 - Expected: -1, Actual: "
                + firstIndex(singleElementArray, 10, 0));
        System.out.println("Test 4: Positive Array, x = 3 - Expected: 2, Actual: " + firstIndex(positiveArray, 3, 0));
        System.out.println("Test 5: Positive Array, x = 6 - Expected: -1, Actual: " + firstIndex(positiveArray, 6, 0));
        System.out.println("Test 6: Negative Array, x = -3 - Expected: 2, Actual: " + firstIndex(negativeArray, -3, 0));
        System.out.println("Test 7: Negative Array, x = 3 - Expected: -1, Actual: " + firstIndex(negativeArray, 3, 0));
        System.out.println("Test 8: Mixed Array, x = 2 - Expected: 1, Actual: " + firstIndex(mixedArray, 2, 0));
        System.out.println("Test 9: Mixed Array, x = -5 - Expected: 4, Actual: " + firstIndex(mixedArray, -5, 0));
        System.out.println("Test 10: Mixed Array, x = 0 - Expected: -1, Actual: " + firstIndex(mixedArray, 0, 0));
        System.out
                .println("Test 11: Duplicate Array, x = 2 - Expected: 1, Actual: " + firstIndex(duplicateArray, 2, 0)); // Important:
                                                                                                                        // Returns
                                                                                                                        // *first*
                                                                                                                        // index
        System.out.println(
                "Test 12: Start Index in Middle, x = 4 - Expected: 3, Actual: " + firstIndex(positiveArray, 4, 2)); // Starts
                                                                                                                    // from
                                                                                                                    // index
                                                                                                                    // 2
        System.out.println(
                "Test 13: Start Index in Middle, x = 1 - Expected: -1, Actual: " + firstIndex(positiveArray, 1, 2)); // Starts
                                                                                                                     // from
                                                                                                                     // index
                                                                                                                     // 2
        System.out.println("Test 14: Null Array - Expected: -1, Actual: " + firstIndex(null, 5, 0));

        int[] arrayWithZero = { 0, 1, 2, 3 };
        System.out.println("Test 15: Array with zero, x = 0 - Expected: 0, Actual: " + firstIndex(arrayWithZero, 0, 0));

    }

}
