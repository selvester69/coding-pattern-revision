package com.practice.algorithms.binarySearch;

public class P15FindMaxElementinBitonicArray {

    public int maxInBitonicArray(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int maxInBitonicArray_2(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((nums[mid] == 0 || nums[mid] > nums[mid - 1]) && (nums[mid] == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
