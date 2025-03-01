package com.practice.algorithms.crackingCodingInterview;

public class P074LongestCommonSubsequence {

    // time complexity of this solution is 2^(min(m,n))
    public static int recursive(String s1, String s2) {
        return lcs(s1, s2, 0, 0);
    }

    public static int lcs(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs(s1, s2, i + 1, j + 1);
        } else {
            return Math.max(lcs(s1, s2, i + 1, j), lcs(s1, s2, i, j + 1));
        }
    }

    // time complexity reduced to O(mn)
    public static int memoized(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        return lcs_memo(s1, s2, 0, 0, memo);
    }

    public static int lcs_memo(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcs_memo(s1, s2, i + 1, j + 1, memo);
            return memo[i][j];
        } else {
            memo[i][j] = Math.max(lcs_memo(s1, s2, i + 1, j, memo), lcs_memo(s1, s2, i, j + 1, memo));
            return memo[i][j];
        }
    }

    public static int bottomUp_DP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {// remember about i-1 and j-1 and not i,j
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(recursive(s1, s2));
        System.out.println(memoized(s1, s2));
        System.out.println(bottomUp_DP(s1, s2));
    }
}
