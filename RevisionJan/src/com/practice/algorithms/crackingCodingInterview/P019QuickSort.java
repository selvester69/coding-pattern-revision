package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P019QuickSort {

    public static int pivot(int[] nums, int pivotIndex, int end) {
        
        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i <= end; i++) {
            if (nums[i] < nums[pivotIndex]) {
                swapIndex++;
                int temp = nums[swapIndex];
                nums[swapIndex] = nums[i];
                nums[i] = temp;
            }
        }
        if (pivotIndex != swapIndex) {
            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[swapIndex];
            nums[swapIndex] = temp;
        }
        return swapIndex;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = pivot(nums, start, end);
        sort(nums, start, pivotIndex - 1);
        sort(nums, pivotIndex + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 7, 9, 1, 2, 4, 6, 8, 0 };
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
