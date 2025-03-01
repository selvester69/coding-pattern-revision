package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P071Fibonacci {

    public static int minStepsTo1_Recursive(int n) {
        if (n == 1)
            return 0;
        int minus = 1 + minStepsTo1_Recursive(n - 1);
        int divideBy3 = Integer.MAX_VALUE;
        if (n % 3 == 0)
            divideBy3 = 1 + minStepsTo1_Recursive(n / 3);
        int divideBy2 = Integer.MIN_VALUE;
        if (n % 2 == 0)
            divideBy2 = 1 + minStepsTo1_Recursive(n / 2);

        return 1 + Math.min(minus, Math.min(divideBy3, divideBy2));
    }

    public static int minStepsTo1_Memo(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        helper(n, ans);
        return ans[n];
    }

    public static int helper(int n, int[] ans) {
        if (n <= 1)
            return 0;
        if (ans[n] != -1) {
            return ans[n];
        }
        int x = helper(n - 1, ans);

        int y = Integer.MIN_VALUE;
        if (n % 2 == 0) {
            y = helper(n / 2, ans);

        }
        int z = Integer.MIN_VALUE;
        if (n % 3 == 0) {
            z = helper(n / 3, ans);
        }
        int calc = Math.min(x, Math.min(y, z));
        ans[n] = calc;
        return calc;
    }

    public static int minStepsTo1_bottomUpDP(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1+dp[i-1];
            if(i%2==0) {
                dp[i] = Math.min(dp[i],1+dp[i/2]);
            }
            if(i%3==0) {
                dp[i] = Math.min(dp[i],1+dp[i/3]);
            }
        }
        return dp[n];
    }
}
