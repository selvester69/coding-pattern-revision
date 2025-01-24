package com.practice.algorithms.crackingCodingInterview;

public class P021BinarySearch {

    public static boolean search(int[] nums, int x) {
        if (nums.length == 0)
            return false;
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == x) {
                return true;
            } else if (x < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int x = 7;
        System.out.println(search(nums, x));
    }

}
