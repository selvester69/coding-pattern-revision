package com.practice.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2342 {

    public static void main(String[] args) {
        maximumSum(new int[] { 229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401 });
    }

    public static int maximumSum(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        int maxSum = -1;
        for (int i = 0; i < nums.length; i++) {
            int digit = calcDigit(nums[i]);
            if (res.containsKey(digit)) {
                maxSum = Math.max(maxSum, nums[i] + res.get(digit));
            } 
            res.put(digit, Math.max(res.getOrDefault(digit, 0), nums[i]));
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static int calcDigit(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d;
        }
        return sum;
    }

}
