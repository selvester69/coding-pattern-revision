package com.practice.algorithms.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P05TopKFrequentNumber {

    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.freq-b.freq);
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int index = 0;
        while (pq.size()>0) {
            res[index++] = pq.poll().num;
        }
        return res;
    }
}
