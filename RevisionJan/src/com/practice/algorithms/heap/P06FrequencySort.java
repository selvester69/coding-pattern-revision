package com.practice.algorithms.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P06FrequencySort {
    class Pair {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.s==b.s){
               return b.f-a.f;
            }else {
                return a.s - b.s;
            }});
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int index=0;
        while(pq.size()>0){
            Pair el = pq.poll();
            int freq = el.s;
            while(freq>0){
                nums[index++] = el.f;
                freq--;
            }
        }
        return nums;

    }

}
