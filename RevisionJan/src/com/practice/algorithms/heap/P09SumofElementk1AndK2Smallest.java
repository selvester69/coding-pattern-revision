package com.practice.algorithms.heap;

import java.util.PriorityQueue;

public class P09SumofElementk1AndK2Smallest {

    public int sumElement(int[] nums, int k1, int k2) {
        int first = findKthSmallest(nums, k1);
        int second = findKthSmallest(nums, k2);
        int index = 0;
        int sum = 0;
        while (index < nums.length) {
            if (nums[index] >= first && nums[index] <= second) {
                sum += nums[index];
            }
        }
        return sum;
    }

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

}
