package com.practice.algorithms.heap;

import java.util.PriorityQueue;

public class P01KsmallestElement {

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);// use max heap to calculate kth smallest element
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
    public static void main(String[] args) {
        P01KsmallestElement solution = new P01KsmallestElement();

        // Test Case 1
        int[] nums1 = {3, 1, 4, 2, 5, 6};
        int k1 = 3;
        int result1 = solution.findKthSmallest(nums1, k1);
        System.out.println("Test Case 1: " + result1); // Output: [1, 2, 3]

        // Test Case 2 (duplicates)
        int[] nums2 = {3, 1, 4, 1, 2, 5};
        int k2 = 3;
        int result2 = solution.findKthSmallest(nums2, k2);
        System.out.println("Test Case 2: " + result2);// Output: [1, 1, 2]

        // Test Case 3 (k equals array length)
        int[] nums3 = {3, 1, 4, 2, 5};
        int k3 = 5;
        int result3 = solution.findKthSmallest(nums3, k3);
        System.out.println("Test Case 3: " + result3); // Output: [1, 2, 3, 4, 5]

        // Test Case 4 (k equals 1)
        int[] nums4 = {3, 1, 4, 2, 5};
        int k4 = 1;
        int result4 = solution.findKthSmallest(nums4, k4);
        System.out.println("Test Case 4: " + result4); // Output: [1]

       

       
      

    }
}

