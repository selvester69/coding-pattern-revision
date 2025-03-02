package com.practice.algorithms.leetcode;

public class Leetcode2460 {

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        int zeroIndex = -1;
        int index = 0;
        while (index < nums.length && nums[index] != 0) {
            index++;
        }
        zeroIndex = index;
        index++;
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[zeroIndex++] = nums[index];
                nums[index] = 0;
            }
            index++;
        }
        return nums;
    }
}
