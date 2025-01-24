package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P022FirstAndLastOccuranceBinarySearch {

    public static int[] findFirstLastOccurance(int[] nums, int target) {
        int[] res = { -1, -1 };
        if (nums.length == 0)
            return res;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] res = findFirstLastOccurance(nums, target);
        System.out.println(Arrays.toString(res));
    }

}
