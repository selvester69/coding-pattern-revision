package com.practice.algorithms.dp;

import java.util.Arrays;

public class Problem02SubsetSum {

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
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursive_memo(arr, sum, n, dp);
    }

    public boolean recursive_memo(int[] wt, int W, int n, int[][] dp) {
        if (W == 0)
            return true;
        if (n <= 0)
            return false;
        if (dp[n][W] != -1) {
            dp[n][W] = 1;
            return dp[n][W] == 1;
        }
        if (wt[n - 1] <= W) {
            boolean res = recursive_memo(wt, W, n - 1, dp) || recursive_memo(wt, W - wt[n - 1], n - 1, dp);
            dp[n][W] = res ? 1 : 0;
            return res;
        }
        boolean res = recursive_memo(wt, W, n - 1, dp);
        dp[n][W] = res ? 1 : 0;
        return res;
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
        Problem02SubsetSum obj = new Problem02SubsetSum();
        // System.out.println(obj.subsetSum_recursive(new int[] { 3, 34, 4, 12, 5, 2 },
        // 9));
        // System.out.println(obj.subsetSum_recursive(new int[] { 3, 34, 4, 12, 5, 2 },
        // 30));

        // System.out.println(obj.subSetSum_memo(new int[] { 3, 34, 4, 12, 5, 2 }, 9));
        // System.out.println(obj.subSetSum_memo(new int[] { 3, 34, 4, 12, 5, 2 }, 30));

        // System.out.println(obj.topdownDP(new int[] { 3, 34, 4, 12, 5, 2 }, 9));
        // System.out.println(obj.topdownDP(new int[] { 3, 34, 4, 12, 5, 2 }, 30));

        System.out.println(obj.subSetSum_memo(new int[] { 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96,
                43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23,
                34, 74, 65, 42, 12, 54, 69, 48, 45, 63, 58, 38, 60, 24, 42, 30, 79, 17, 36 }, 2191));
    }

}
