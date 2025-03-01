package com.practice.algorithms.crackingCodingInterview;

public class P076ClimbStairs {

    // 2 jumps allowed
    public static int count_Steps_recursive(int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return 1;

        return count_Steps_recursive(n - 1) + count_Steps_recursive(n - 2);
    }

    public static int count_steps_dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // adding generalization for k jumps.
    public static int count_steps_dp_generalized(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int ans = 0;
            for (int j = 1; j <= k; j++) {
                ans += dp[i - j];
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(count_Steps_recursive(4));
        System.out.println(count_steps_dp(4));
    }
}
