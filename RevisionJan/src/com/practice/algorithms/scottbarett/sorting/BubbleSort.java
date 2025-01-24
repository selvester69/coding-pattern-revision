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
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

}
