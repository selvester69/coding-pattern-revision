package com.practice.algorithms.crackingCodingInterview;

public class P021LinearSeach {

    public static boolean search(int[] nums, int x) {
        if (nums.length == 0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return true;
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
