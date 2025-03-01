package com.practice.algorithms.crackingCodingInterview;

public class P077_0_1knapsack {

    // maximize profit using picking or not picking
    public static int knapsack(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0)
            return 0;
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));
        } else {
            return knapsack(wt, val, W, n - 1);
        }
    }

    // since there are 2 variables at play for change we consider both variables
    public static int knapsack_memoized(int[] wt, int[] val, int W) {
        int[][] memo = new int[wt.length + 1][W + 1];
        helper(wt, val, W, wt.length, memo);
        return memo[wt.length][W];
    }

    public static int helper(int[] wt, int[] val, int W, int n, int[][] memo) {
        if (n == 0 || W == 0)
            return 0;
        if (memo[n][W] != 0)
            return memo[n][W];

        if (wt[n - 1] <= W) {
            memo[n][W] = Math.max(val[n - 1] + helper(wt, val, W - wt[n - 1], n - 1, memo),
                    helper(wt, val, W, n - 1, memo));
            return memo[n][W];
        } else {
            memo[n][W] = helper(wt, val, W, n - 1, memo);
            return memo[n][W];
        }
    }

    public static int knapsack_BottomUP_DP(int[] wt, int[] val, int W, int N) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    // space optimization for above
    public static int knapsack_space_DP(int[] wt, int[] val, int W, int N) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w) {
                    dp[w] = Math.max(dp[w], val[i - 1] + dp[w - wt[i - 1]]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }, 50, 3));
        System.out.println(knapsack_memoized(new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }, 50));
        System.out.println(knapsack_BottomUP_DP(new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }, 50, 3));
        System.out.println(knapsack_space_DP(new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }, 50, 3));
    }

}
