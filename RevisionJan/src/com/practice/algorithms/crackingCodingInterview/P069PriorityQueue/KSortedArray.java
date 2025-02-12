package com.practice.algorithms.crackingCodingInterview.P069PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {

    // naive approach is any sorting algo
    // below solution time complexity is nlogk
    public static void nearlySorted(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            queue.add(nums[i]);
            i++;
        }
        while (i < nums.length) {
            queue.add(nums[i]);
            nums[i - k] = queue.poll();
            i++;
        }
        while (!queue.isEmpty()) {
            nums[i - k] = queue.poll();
            i++;
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 6, 5, 3, 2, 8, 10, 9 };

        nearlySorted(arr, k);

        // for (int x : arr) {
        // System.out.print(x + " ");
        // }
    }
}
