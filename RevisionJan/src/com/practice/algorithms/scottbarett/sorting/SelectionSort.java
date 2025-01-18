package com.practice.algorithms.scottbarett.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] myArray = { 4, 2, 6, 5, 1, 3 };

        selectionSort(myArray);

        System.out.println(Arrays.toString(myArray));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * [1, 2, 3, 4, 5, 6]
         * 
         */

    }

    private static void selectionSort(int[] nums) {
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
}
