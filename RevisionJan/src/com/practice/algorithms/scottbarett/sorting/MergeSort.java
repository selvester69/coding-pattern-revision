package com.practice.algorithms.scottbarett.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] combined = new int[n1 + n2];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < n1 && index2 < n2) {
            if (nums1[index1] < nums2[index2]) {
                combined[index++] = nums1[index1++];
            }
            else {
                combined[index++] = nums2[index2++];
            }
        }
        while (index1 < n1) {
            combined[index++] = nums1[index1++];
        }
        while (index2 < n2) {
            combined[index++] = nums2[index2++];
        }
        return combined;
    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    public static void testMerge() {

        int[] array1 = {1,3,7,8};
        int[] array2 = {2,4,5,6};

        System.out.println("merge test ->" + Arrays.toString(merge(array1, array2)));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * [1, 2, 3, 4, 5, 6, 7, 8]
         * 
         * F
         */

    }

    public static void main(String[] args) {
        testMerge();
        
        int[] originalArray = { 3, 1, 4, 2 };

        int[] sortedArray = mergeSort(originalArray);

        System.out.println("Original Array: " + Arrays.toString(originalArray));

        System.out.println("\nSorted Array: " + Arrays.toString(sortedArray));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Original Array: [3, 1, 4, 2]
         * 
         * Sorted Array: [1, 2, 3, 4]
         * 
         */

    }
}
