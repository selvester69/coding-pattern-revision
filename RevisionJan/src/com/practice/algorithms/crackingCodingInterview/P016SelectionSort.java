package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P016SelectionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

     public static void main(String[] args) {
        int[] res = new int[] { 3, 6, 5, 2, 7, 9, 1 };
        sort(res);
        System.out.println(Arrays.toString(res));
    }
}
