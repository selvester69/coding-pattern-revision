package com.practice.algorithms.heap;

import java.util.PriorityQueue;

// Q sort a k sorted array or nearly sorted array.
public class P03KsortedArraySort {

    public int[] ksortedArrays(int[] nums,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                nums[j++] = pq.poll();
            }
        }
        while (pq.size()>0) {
            nums[j++] = pq.poll();
        }
        return nums;
    }

}
