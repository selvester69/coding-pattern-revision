package com.practice.algorithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode3066 {
    public static int minOperations(int[] nums, int k) {
        if (nums.length < 2)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int op = 0;
        while (pq.peek() < k && pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int res = Math.min(num1, num2) * 2 + Math.max(num1, num2);
            op++;
            pq.add(res);
        }
        int resArr[] = new int[pq.size()];
        int i = 0;
        while (pq.size() > 0) {
            resArr[i++] = pq.poll();
        }
        System.out.println(Arrays.toString(resArr));
        return op;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1000000000,999999999,1000000000,999999999,1000000000,999999999},1000000000));//2
        // System.out.println(minOperations(new int[]{2,11,10,1,3},10));//2
        // System.out.println(minOperations(new int[]{1,1,2,4,9},20));//4
    }
}
