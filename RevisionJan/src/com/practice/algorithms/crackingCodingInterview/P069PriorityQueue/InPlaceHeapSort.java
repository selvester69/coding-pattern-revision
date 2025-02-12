package com.practice.algorithms.crackingCodingInterview.P069PriorityQueue;

import java.util.Arrays;

public class InPlaceHeapSort {

    public static void heapSort(int[] nums) {
        // build min heap
        for (int i = 1; i < nums.length; i++) {
            int cI = i;
            while (cI > 0) {
                int pI = (cI - 1) / 2;
                if (nums[cI] < nums[pI]) {
                    int temp = nums[cI];
                    nums[cI] = nums[pI];
                    nums[pI] = temp;
                    cI = pI;
                } else {
                    break;
                }
            }
        }
        // remove elements n times;
        int size = nums.length;
        while (size >= 1) {
            int temp = nums[0];
            nums[0] = nums[size - 1];
            nums[size - 1] = temp;
            size--;
            // after swap down heapify
            int index = 0;
            while (true) {
                int cI1 = index * 2 + 1;
                int cI2 = index * 2 + 2;
                int minIndex = index;

                if (cI1 < size && nums[cI1] < nums[minIndex]) {
                    minIndex = cI1;
                }
                if (cI2 < size && nums[cI2] < nums[minIndex]) {
                    minIndex = cI2;
                }

                if (minIndex != index) {
                    int temp2 = nums[minIndex];
                    nums[minIndex] = nums[index];
                    nums[index] = temp2;
                    index = minIndex;
                } else {
                    break;
                }
            }

        }
    }
    public static void main(String[] args) {
        int[]nums = {3,5,2,6,1,7,9,20};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
