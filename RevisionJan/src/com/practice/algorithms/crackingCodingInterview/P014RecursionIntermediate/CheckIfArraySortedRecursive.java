package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class CheckIfArraySortedRecursive {

    public static boolean isSorted(int[] nums, int n) {
        // base case
        if (n == 0 || n == 1)
            return true;

        // recursive case
        if (nums[n - 2] > nums[n - 1]) {
            return false;
        }
        return isSorted(nums, n - 1);
    }
    public static void main(String[] args) {
        // Test cases
        int[] emptyArray = {};
        int[] singleElementArray = {5};
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {1, 3, 2, 4, 5};
        int[] duplicateSortedArray = {1, 2, 2, 4, 5};
        int[] reverseSortedArray = {5, 4, 3, 2, 1};
        int[] negativeSortedArray = {-5, -2, 0, 3, 7};
        int[] negativeUnsortedArray = {-5, -2, 0, -1, 7};


        System.out.println("Test 1: Empty Array - Expected: true, Actual: " + isSorted(emptyArray, emptyArray.length));
        System.out.println("Test 2: Single Element Array - Expected: true, Actual: " + isSorted(singleElementArray, singleElementArray.length));
        System.out.println("Test 3: Sorted Array - Expected: true, Actual: " + isSorted(sortedArray, sortedArray.length));
        System.out.println("Test 4: Unsorted Array - Expected: false, Actual: " + isSorted(unsortedArray, unsortedArray.length));
        System.out.println("Test 5: Duplicate Sorted Array - Expected: true, Actual: " + isSorted(duplicateSortedArray, duplicateSortedArray.length));
        System.out.println("Test 6: Reverse Sorted Array - Expected: false, Actual: " + isSorted(reverseSortedArray, reverseSortedArray.length));
        System.out.println("Test 7: Negative Sorted Array - Expected: true, Actual: " + isSorted(negativeSortedArray, negativeSortedArray.length));
        System.out.println("Test 8: Negative Unsorted Array - Expected: false, Actual: " + isSorted(negativeUnsortedArray, negativeUnsortedArray.length));
        System.out.println("Test 9: Null Array - Expected: true, Actual: " + isSorted(null, 0));
        int [] arrayWithOneNegativeElement = {-1};
         System.out.println("Test 10: Array with one negative element - Expected: true, Actual: " + isSorted(arrayWithOneNegativeElement, arrayWithOneNegativeElement.length));


    }


}
