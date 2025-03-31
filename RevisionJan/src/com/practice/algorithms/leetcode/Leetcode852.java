package com.practice.algorithms.leetcode;

public class Leetcode852 {

    // BruteForce solution
    // improvement in loop is
    // run till the time i is less than i+1;
    public int peakIndexInMountainArray_bruteForce(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                max = i + 1;
            }
        }
        return max;
    }

    // constraint given is min 3 element in arr
    public int peakIndexInMountainArray_binary(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid > 0 && mid < n - 1)) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {

                } else if (nums[mid] > nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid == 0) {
                return nums[0] > nums[1] ? 0 : 1;
            } else if (mid == n - 1) {
                return nums[mid - 1] > nums[mid - 2] ? mid - 1 : mid - 2;
            }
        }
        return -1;
    }

    // another approach with optimized solution
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else  {
                end = mid;
            }
        }
        return start;
    }

}
