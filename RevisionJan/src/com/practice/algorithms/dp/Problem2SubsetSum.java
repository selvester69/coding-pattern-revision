package com.practice.algorithms.dp;

import java.util.Arrays;

public class Problem2SubsetSum {

    public boolean subsetSum_recursive(int[] arr, int Sum) {
        int n = arr.length;
        return recursive(arr, Sum, n);
    }

    public boolean recursive(int[] wt, int W, int n) {
        if (W == 0)
            return true;
        if (n == 0)
            return false;

        if (wt[n - 1] <= W) {
            return recursive(wt, W - wt[n - 1], n - 1) || recursive(wt, W, n - 1);
        }
        return recursive(wt, W, n - 1);
    }

    public boolean subSetSum_memo(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        return recursive_memo(arr, sum, n, dp);
    }

    public boolean recursive_memo(int[] wt, int W, int n, boolean[][] dp) {
        if (W == 0)
            return true;
        if (n == 0)
            return false;
        if (dp[n - 1][W - 1]) {
            return dp[n - 1][W - 1];
        }
        if (wt[n - 1] <= W) {
            dp[n][W] = recursive_memo(wt, W, n - 1, dp) || recursive_memo(wt, W - wt[n - 1], n - 1, dp);
            return dp[n][W];
        }
        dp[n][W] = recursive_memo(wt, W, n - 1, dp);
        return dp[n][W];
    }

    public boolean topdownDP(int[] arr, int Sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][Sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Sum; j++) {
                // no need to handle i==0 as it will be false anyways.
                if (i == 0) {
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][Sum];
    }

    public static void main(String[] args) {
        Problem2SubsetSum obj = new Problem2SubsetSum();
        System.out.println(obj.subsetSum_recursive(new int[] { 3, 34, 4, 12, 5, 2 },
        9));
        System.out.println(obj.subsetSum_recursive(new int[] { 3, 34, 4, 12, 5, 2 },
        30));

        System.out.println(obj.subSetSum_memo(new int[] { 3, 34, 4, 12, 5, 2 }, 9));
        System.out.println(obj.subSetSum_memo(new int[] { 3, 34, 4, 12, 5, 2 }, 30));

        System.out.println(obj.topdownDP(new int[] { 3, 34, 4, 12, 5, 2 }, 9));
        System.out.println(obj.topdownDP(new int[] { 3, 34, 4, 12, 5, 2 }, 30));

    }

}
