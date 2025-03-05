package com.practice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2161 {

    public int[] pivotArray_bruteforce(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        int count = 0;
        List<Integer> more = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                less.add(nums[i]);
            } else if (nums[i] > pivot) {
                more.add(nums[i]);
            } else {
                count++;
            }
        }
        int index = 0, i = 0;
        while (index < less.size()) {
            nums[i] = less.get(index);
            index++;
            i++;
        }
        while (count > 0) {
            nums[i] = pivot;
            i++;
            count--;
        }
        index = 0;
        while (index < more.size()) {
            nums[i] = more.get(index);
            index++;
            i++;
        }
        return nums;
    }

    public int[] pivotArray_twopass(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[index++] = nums[i];
            }
            if (nums[i] == pivot) {
                count++;
            }
        }
        while (count > 0) {
            res[index++] = pivot;
            count--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                res[index++] = nums[i];
            }
        }
        return res;
    }

    public static int[] pivotArray_twopointer(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int start = 0, end = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[start] = nums[i];
                start++;
            }
            if (nums[j] > pivot) {
                ans[end] = nums[j];
                end--;
            }
        }
        while (start <= end) {
            ans[start] = pivot;
            start++;
        }
        return ans;
    }
    public static void main(String[] args) {
        

        // Test Case 1: Simple case
        int[] nums1 = {9, 12, 5, 10, 14, 3, 10};
        int pivot1 = 10;
        int[] expected1 = {9, 5, 3, 10, 10, 12, 14};
        test( nums1, pivot1, expected1, "Test Case 1");

        // Test Case 2: All elements less than pivot
        int[] nums2 = {1, 2, 3, 4, 5};
        int pivot2 = 6;
        int[] expected2 = {1, 2, 3, 4, 5};
        test( nums2, pivot2, expected2, "Test Case 2");

        // Test Case 3: All elements greater than pivot
        int[] nums3 = {5, 4, 3, 2, 1};
        int pivot3 = 0;
        int[] expected3 = {5, 4, 3, 2, 1};
        test(nums3, pivot3, expected3, "Test Case 3");

        // Test Case 4: All elements equal to pivot
        int[] nums4 = {10, 10, 10, 10, 10};
        int pivot4 = 10;
        int[] expected4 = {10, 10, 10, 10, 10};
        test( nums4, pivot4, expected4, "Test Case 4");

        // Test Case 5: Empty array
        int[] nums5 = {};
        int pivot5 = 5;
        int[] expected5 = {};
        test(nums5, pivot5, expected5, "Test Case 5");

        // Test Case 6: Array with one element
        int[] nums6 = {7};
        int pivot6 = 7;
        int[] expected6 = {7};
        test(nums6, pivot6, expected6, "Test Case 6");

        // Test Case 7: Array with negative numbers
        int[] nums7 = {-5, -2, 0, 3, -1, 4};
        int pivot7 = 0;
        int[] expected7 = {-5, -2, -1, 0, 3, 4};
        test( nums7, pivot7, expected7, "Test Case 7");

        // Test Case 8: Array with duplicate elements
        int[] nums8 = {3, 5, 2, 5, 1, 5};
        int pivot8 = 5;
        int[] expected8 = {3, 2, 1, 5, 5, 5};
        test(nums8, pivot8, expected8, "Test Case 8");

        // Test Case 9: pivot is first element
        int[] nums9 = {5, 3, 1, 4, 2};
        int pivot9 = 5;
        int[] expected9 = {3, 1, 4, 2, 5};
        test( nums9, pivot9, expected9, "Test Case 9");

        // Test Case 10: pivot is last element
        int[] nums10 = {1, 2, 3, 4, 5};
        int pivot10 = 5;
        int[] expected10 = {1, 2, 3, 4, 5};
        test(nums10, pivot10, expected10, "Test Case 10");
    }

    private static void test(int[] nums, int pivot, int[] expected, String testName) {
        int[] actual = pivotArray_twopointer(nums, pivot);
        System.out.println(testName + ": " + (Arrays.equals(actual, expected) ? "Passed" : "Failed"));
        if (!Arrays.equals(actual, expected)) {
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(actual));
        }
    }
}
