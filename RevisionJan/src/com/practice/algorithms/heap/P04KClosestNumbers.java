package com.practice.algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P04KClosestNumbers {
    class Pair<K,V> {
        public int f;
        public int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    // find k closest numbers to x.
    public int[] kclosestNumbers(int[] nums, int k, int x) {
        int[] res = new int[k];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> {
            if(Math.abs(b.f-a.f)==0){
                return b.s-a.s;// in case 2 values are equal compare elements and use smaller element
            }else {
                return b.f-a.f;
            }
            });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair<>(Math.abs(x - nums[i]), nums[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        while (pq.size() > 0) {
            Pair<Integer, Integer> p = pq.poll();
            nums[i++] = p.s;
        }

        return res;
    }

    // brute force
    public int[] bruteforce(int[] nums, int k, int x) {
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] = Math.abs(nums[i] - x);
        }
        List<Integer> res = new ArrayList<>();
        // find k smallest numbers in diff array. and add nums[index] to list.
        for (int i = 0; i < diff.length; i++) {

        }
        return diff;// fix
    }

}
