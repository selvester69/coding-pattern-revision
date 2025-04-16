package com.practice.algorithms.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P08ConnectingRopes {

    // brute force solution is to use list and sort at each insert to find the
    // minimum element to minimie the cost;
    public int connectingRopes_bruteForce(int[] nums) {
        int cost = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (list.size() > 1) {
            Collections.sort(list);
            int item = list.removeFirst();
            int item2 = list.removeFirst();
            int total = item + item2;
            list.add(total);
            cost += total;
        }
        return cost;
    }

    public int connectingRopes(int[] nums) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }
        while (pq.size() > 1) {
            int item1 = pq.poll();
            int item2 = pq.poll();
            int sum = item1 + item2;
            cost += sum;
            pq.add(sum);
        }
        return cost;
    }

}
