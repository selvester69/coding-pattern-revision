package com.practice.algorithms.binarySearch;

import java.util.Arrays;
import java.util.Collections;

public class P02BinarySearchOnReverseSortedArray {

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 12, 9, 5, 3, 0, -1};
        System.out.println(search(nums1, 0));
    }

}
