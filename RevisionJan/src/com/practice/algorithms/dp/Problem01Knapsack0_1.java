package com.practice.algorithms.dp;

import java.util.Arrays;

public class Problem01Knapsack0_1 {

    public int maxProfit_recursive(int val[], int wt[], int W) {
        int n = wt.length;
        return recursive(val, wt, W, n);
    }

    public int recursive(int val[], int wt[], int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + recursive(val, wt, W - wt[n - 1], n - 1), recursive(val, wt, W, n - 1));
        }
        return recursive(val, wt, W, n - 1);
    }

    // memoization
    public int maxProfit_memo(int val[], int wt[], int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res =  recursive_memo(val, wt, W, n, dp);
        printDP(dp);
        return res;
    }

    public int recursive_memo(int[] val, int[] wt, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + recursive_memo(val, wt, W - wt[n - 1], n - 1, dp),
                    recursive_memo(val, wt, W, n - 1, dp));
            return dp[n][W];
        }
        dp[n][W] = recursive_memo(val, wt, W, n - 1, dp);
        return dp[n][W];
    }

    public int topdownDP(int val[], int wt[], int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("Top down dp");
        printDP(dp);
        return dp[n][W];
    }

    public static void main(String[] args) {
        Problem01Knapsack0_1 obj = new Problem01Knapsack0_1();
        int W = 4, val[] = { 1, 2, 3 }, weight[] = { 4, 5, 1 };
        System.out.println(obj.maxProfit_recursive(val, weight, W));
        System.out.println(obj.maxProfit_memo(val, weight, W));
        System.out.println(obj.topdownDP(val, weight, W));
    }

    public void printDP(int[][]dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
