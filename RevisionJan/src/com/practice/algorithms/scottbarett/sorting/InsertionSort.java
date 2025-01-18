package com.practice.algorithms.scottbarett.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] myArray = { 4, 2, 6, 5, 1, 3 };

        insertionSort(myArray);

        System.out.println(Arrays.toString(myArray));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * [1, 2, 3, 4, 5, 6]
         * 
         */

    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0 && temp<nums[j]) {
                nums[j + 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }

}
