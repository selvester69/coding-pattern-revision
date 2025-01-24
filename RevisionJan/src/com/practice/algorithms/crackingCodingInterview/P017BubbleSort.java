package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P017BubbleSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j =0; j < nums.length-i-1; j++) {
                if (nums[j] >nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public static void main(String[] args) {
        int[] res = new int[] { 3, 6, 5, 2, 7, 9, 1 };
        sort(res);
        System.out.println(Arrays.toString(res));
    }

}
