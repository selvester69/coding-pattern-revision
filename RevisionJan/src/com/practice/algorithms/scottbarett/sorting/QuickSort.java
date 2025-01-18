package com.practice.algorithms.scottbarett.sorting;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int pivot(int[] arr, int pivotIndex, int end) {
        int swapindex = pivotIndex;
        for (int i = pivotIndex + 1; i <= end; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapindex++;
                swap(arr, swapindex, i);
            }
        }
        swap(arr,pivotIndex, swapindex );

        return swapindex;
    }

    public static void quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
        return;
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    public static void main(String[] args) {

        int[] myArray = { 4, 6, 1, 7, 8, 3, 2, 5 };

        quickSort(myArray);

        System.out.println(Arrays.toString(myArray));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Returned Index: 3
         * [2, 1, 3, 4, 6, 7, 5]
         * 
         */

    }
}
