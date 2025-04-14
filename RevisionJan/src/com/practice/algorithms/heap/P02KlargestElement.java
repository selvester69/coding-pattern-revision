package com.practice.algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P02KlargestElement {

    // brute force way is to sort the whole array and find element at k index

    //optimized approach is to use heap which converts O(nlog n) to O(n log k). 
    public List<Integer> kLargestElement(int[]nums, int k){
        Queue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);// need largest element therefore remove small elements.
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(pq.size()>0){
            res.add(pq.poll());
        }
        return res;
    }

}
