package com.practice.algorithms.crackingCodingInterview;

public class P075EditDistance {

    public static int recursive(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return editDistance(s1, s2, m, n);
    }

    public static int editDistance(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;// String 1 empty insert all char of s2

        if (n == 0)
            return m;// if s2 is empty delete all char from s1;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistance(s1, s2, m - 1, n - 1);
        } else {
            return 1 + Math.min(editDistance(s1, s2, m, n - 1),
                    Math.min(editDistance(s1, s2, m - 1, n), editDistance(s1, s2, m - 1, n - 1)));
        }
    }

    public static int memoization(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        return editDistance_Memo(s1, s2, m, n, memo);

    }

    public static int editDistance_Memo(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0)
            return n;// String 1 empty insert all char of s2
        if (n == 0)
            return m;// if s2 is empty delete all char from s1;
        if (memo[m][n] != 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = editDistance_Memo(s1, s2, m - 1, n - 1, memo);
            return memo[m][n];
        } else {
            memo[m][n] = 1 + Math.min(editDistance_Memo(s1, s2, m, n - 1, memo),
                    Math.min(editDistance_Memo(s1, s2, m - 1, n, memo), editDistance_Memo(s1, s2, m - 1, n - 1, memo)));
            return memo[m][n];
        }
    }

    public static int editDistance_DP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1+Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(recursive("horse", "ros"));
        System.out.println(memoization("horse", "ros"));
        System.out.println(editDistance_DP("horse", "ros"));
    }

}
