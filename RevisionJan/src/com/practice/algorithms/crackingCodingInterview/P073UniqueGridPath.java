package com.practice.algorithms.crackingCodingInterview;

public class P073UniqueGridPath {

    /**
     * 
     * we are using condition m==1 || n==1 then return 1 because
     * for m==1 n<1 will always be 0 and n-1 will not exist there for we count it as
     * 1 path
     * same for n==1
     * 
     * instead of them we can use below conditions also
     * if(m==0 && n==0) return 1
     * if(m<0 && n<0) return 0;
     * 
     */

    // recursive function time complexity is 2^(m+n);
    public static int uniquePath_recursive(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePath_recursive(m - 1, n) + uniquePath_recursive(m, n - 1);
    }

    // top down dp aka memoization optimized the solution to O(mn) time and O(mn)
    // space
    public static int uniquePath_topDownDP_Memoization(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(m, n, dp);
    }

    public static int helper(int m, int n, int[][] dp) {
        if (m == 1 || n == 1)
            return 1;
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        dp[m][n] = helper(m - 1, n, dp) + helper(m, n - 1, dp);
        return dp[m][n];
    }

    // to further reduce the recursion stack space we can use bottom up dp with same
    // time and space complexity
    public static int bottomUp_DP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int bottomUp_DP_another_way(int m, int n) {
        int[][] dp = new int[m][n];
        // instead of above loop we can use below condition
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    // futher optimze space to only use previous row
    public static int bottomUp_DP_spaceOptimize(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static int factorialSolution(int m, int n) {
        /**
         * mxn matrix is given and we can go m-1 right steps and n-1 down steps
         * therefore all permutations of m-1 x n-1 will give correct ans;
         * formula = (m-1 + n-1 )! / (m-1)! (n-1)!
         * therefor (m+n-2)! / (m-1)!(n-1)!
         * cancelling n-1! terms
         * 1x2x3x4...(n-1) x n x (n+1)x (n+2) ... (n+(m-2))
         * ------------------------------------------------
         * (n-1)! (m-1)!
         * 
         * there fore final formula is
         * n x (n+1)x (n+2) ... (n+(m-2)) / (m-1)!
         * 
         * 
         * time = O(m) space=O(1)
         */
        long ans = 1;
        for (int i = n; i <= n + m - 2; i++) {
            ans = ans * i;
            ans = ans / (i - n + 1);
        }
        return (int) ans;
    }

    public static void main(String[] args) {

        System.out.println(uniquePath_recursive(3, 7));
        System.out.println(uniquePath_topDownDP_Memoization(3, 7));
        System.out.println(bottomUp_DP(3, 7));
        System.out.println(bottomUp_DP_spaceOptimize(3, 7));
        System.out.println(factorialSolution(3, 7));
    }
}
