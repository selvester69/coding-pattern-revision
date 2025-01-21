package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class CheckIfElementPresent {

    public static boolean isElementPresent(int[] nums, int x, int index) {
        // base case
        if (index >= nums.length)
            return false;
        if (nums[index] == x)
            return true;

        return isElementPresent(nums, x, index + 1);
    }

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] singleElementArray = {5};
        int[] positiveArray = {1, 2, 3, 4, 5};
        int[] negativeArray = {-1, -2, -3, -4, -5};
        int[] mixedArray = {-1, 2, -3, 4, -5};
        int[] duplicateArray = {1, 2, 2, 4, 5};

        System.out.println("Test 1: Empty Array, x = 5 - Expected: false, Actual: " + isElementPresent(emptyArray, 5, 0));
        System.out.println("Test 2: Single Element Array, x = 5 - Expected: true, Actual: " + isElementPresent(singleElementArray, 5, 0));
        System.out.println("Test 3: Single Element Array, x = 10 - Expected: false, Actual: " + isElementPresent(singleElementArray, 10, 0));
        System.out.println("Test 4: Positive Array, x = 3 - Expected: true, Actual: " + isElementPresent(positiveArray, 3, 0));
        System.out.println("Test 5: Positive Array, x = 6 - Expected: false, Actual: " + isElementPresent(positiveArray, 6, 0));
        System.out.println("Test 6: Negative Array, x = -3 - Expected: true, Actual: " + isElementPresent(negativeArray, -3, 0));
        System.out.println("Test 7: Negative Array, x = 3 - Expected: false, Actual: " + isElementPresent(negativeArray, 3, 0));
        System.out.println("Test 8: Mixed Array, x = 2 - Expected: true, Actual: " + isElementPresent(mixedArray, 2, 0));
        System.out.println("Test 9: Mixed Array, x = -5 - Expected: true, Actual: " + isElementPresent(mixedArray, -5, 0));
        System.out.println("Test 10: Mixed Array, x = 0 - Expected: false, Actual: " + isElementPresent(mixedArray, 0, 0));
        System.out.println("Test 11: Duplicate Array, x = 2 - Expected: true, Actual: " + isElementPresent(duplicateArray, 2, 0));
        System.out.println("Test 12: Start Index in Middle, x = 4 - Expected: true, Actual: " + isElementPresent(positiveArray, 4, 2));
        System.out.println("Test 13: Start Index in Middle, x = 1 - Expected: false, Actual: " + isElementPresent(positiveArray, 1, 2));
        System.out.println("Test 14: Null Array - Expected: false, Actual: " + isElementPresent(null, 5, 0));

    }

}
