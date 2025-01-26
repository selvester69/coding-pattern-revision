package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P029JumpGame2 {

    // approach 1 recursion
    // optimize approach 2 memoization
    // optimize approach 3 dp
    // full optimize greedy approach
    // another way to use greedy approach
    public static int jump_recursive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = helper(0, nums);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public static int helper(int i, int[] nums) {
        if (i >= nums.length - 1)
            return 0;

        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + nums[i]; j++) {
            int val = helper(j, nums);
            if (val != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + val);
            }
        }
        return ans;
    }

    public static int jump_memo(int[] nums) {
        int[] memo = new int[nums.length];
        // initialize dp to -1;
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        int res = memo_helper(0, nums, memo);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public static int memo_helper(int i, int[] nums, int memo[]) {
        if (i >= nums.length - 1)
            return 0;

        if (memo[i] != -1) {
            return memo[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + nums[i]; j++) {
            int val = memo_helper(j, nums, memo);
            if (val != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + val);
            }
        }
        memo[i] = ans;
        return ans;
    }

    public static int jump_dp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        if (dp[0] == Integer.MAX_VALUE) {
            return -1;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    // ==============MOst efficient approach using greedy =========
    public static int jump(int[] nums) {

        if (nums.length == 1)
            return 0;
        if (nums[0] == 0)
            return -1;

        int maxIndex = nums[0];
        int index = nums[0];
        int jump = 1;

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1)
                return jump;

            if (i + nums[i] > maxIndex) {
                maxIndex = i + nums[i];
            }
            index--;
            if (index == 0) {
                jump++;
                if (i >= maxIndex) {
                    return -1;
                }
                index = maxIndex - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases using recursion

        System.out.println("Test Case 1: " + (jump_recursive(new int[] { 2, 3, 1, 1, 4 }) == 2));
        System.out.println("Test Case 2: " + (jump_recursive(new int[] { 2, 3, 0, 1, 4 }) == 2));
        System.out.println("Test Case 3: " + (jump_recursive(new int[] { 1, 2, 3, 4, 5 }) == 3));
        System.out.println("Test Case 4: " + (jump_recursive(new int[] { 5, 4, 3, 2, 1, 1, 1 }) == 2));
        System.out.println("Test Case 5: " + (jump_recursive(new int[] { 1, 1, 1, 1 }) == 3));
        System.out.println("Test Case 6: " + (jump_recursive(new int[] { 10, 1, 1, 1, 1 }) == 1));
        System.out.println("Test Case 7: " + (jump_recursive(new int[] { 2, 1 }) == 1));

        System.out.println("Test Case 1: " + (jump_memo(new int[] { 2, 3, 1, 1, 4 }) == 2));
        System.out.println("Test Case 2: " + (jump_memo(new int[] { 2, 3, 0, 1, 4 }) == 2));
        System.out.println("Test Case 3: " + (jump_memo(new int[] { 1, 2, 3, 4, 5 }) == 3));
        System.out.println("Test Case 4: " + (jump_memo(new int[] { 5, 4, 3, 2, 1, 1, 1 }) == 2));
        System.out.println("Test Case 5: " + (jump_memo(new int[] { 1, 1, 1, 1 }) == 3));
        System.out.println("Test Case 6: " + (jump_memo(new int[] { 10, 1, 1, 1, 1 }) == 1));
        System.out.println("Test Case 7: " + (jump_memo(new int[] { 2, 1 }) == 1));

        System.out.println("Test Case 1: " + (jump_dp(new int[] { 2, 3, 1, 1, 4 }) == 2));
        System.out.println("Test Case 2: " + (jump_dp(new int[] { 2, 3, 0, 1, 4 }) == 2));
        System.out.println("Test Case 3: " + (jump_dp(new int[] { 1, 2, 3, 4, 5 }) == 3));
        System.out.println("Test Case 4: " + (jump_dp(new int[] { 5, 4, 3, 2, 1, 1, 1 }) == 2));
        System.out.println("Test Case 5: " + (jump_dp(new int[] { 1, 1, 1, 1 }) == 3));
        System.out.println("Test Case 6: " + (jump_dp(new int[] { 10, 1, 1, 1, 1 }) == 1));
        System.out.println("Test Case 7: " + (jump_dp(new int[] { 2, 1 }) == 1));
       
        //Greedy algo
        System.out.println("Test Case 1: " + (jump(new int[] { 2, 3, 1, 1, 4 }) == 2));
        System.out.println("Test Case 2: " + (jump(new int[] { 2, 3, 0, 1, 4 }) == 2));
        System.out.println("Test Case 3: " + (jump(new int[] { 1, 2, 3, 4, 5 }) == 3));
        System.out.println("Test Case 4: " + (jump(new int[] { 5, 4, 3, 2, 1, 1, 1 }) == 2));
        System.out.println("Test Case 5: " + (jump(new int[] { 1, 1, 1, 1 }) == 3));
        System.out.println("Test Case 6: " + (jump(new int[] { 10, 1, 1, 1, 1 }) == 1));
        System.out.println("Test Case 7: " + (jump(new int[] { 2, 1 }) == 1));
    }

}
