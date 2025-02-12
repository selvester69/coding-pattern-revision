package com.practice.algorithms.crackingCodingInterview.P069PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int findKthSmallest_Naive(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k-1];
    }

    public static int findKthSmallest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b.compareTo(a));
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(findKthSmallest_Naive(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println(findKthSmallest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }

}
