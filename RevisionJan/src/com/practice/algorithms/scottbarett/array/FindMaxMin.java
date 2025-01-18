package com.practice.algorithms.scottbarett.array;

import java.util.Arrays;

public class FindMaxMin {

    public static void main(String[] args) {

        int[] myList1 = { 5, 3, 8, 1, 6, 9 };
        int[] result1 = findMaxMin(myList1);
        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"

        int[] myList2 = { -5, -3, -8, -1, -6, -9 };
        int[] result2 = findMaxMin(myList2);
        System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"

        int[] myList3 = { 0, 0, 0, 0, 0 };
        int[] result3 = findMaxMin(myList3);
        System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"

        int[] myList4 = { 100, 200, 300, 400, 500 };
        int[] result4 = findMaxMin(myList4);
        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Test case 1: MaxMin: [9, 1]
         * Test case 2: MaxMin: [-1, -9]
         * Test case 3: MaxMin: [0, 0]
         * Test case 4: MaxMin: [500, 100]
         */

    }

    private static int[] findMaxMin(int[] nums) {
        int res[] = new int[2];
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res[0] = Math.max(nums[i], res[0]);
            res[1] = Math.min(nums[i], res[1]);
        }
        return res;
    }

}
