package com.practice.algorithms.scottbarett.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] myArray = { 6, 5, 4, 3, 2, 1 };

        bubbleSort(myArray);

        System.out.println(Arrays.toString(myArray));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * [1, 2, 3, 4, 5, 6]
         * 
         */

    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
