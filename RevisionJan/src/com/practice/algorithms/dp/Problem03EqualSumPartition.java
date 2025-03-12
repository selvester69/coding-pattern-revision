package com.practice.algorithms.dp;

public class Problem03EqualSumPartition {

    public boolean subsetSum_recursive(int[] arr, int Sum, int n,boolean[][]dp) {
        if (Sum == 0)
            return true;
        if (n == 0)
            return false;

        if (arr[n - 1] <= Sum) {
           return dp[n][Sum] = subsetSum_recursive(arr, Sum, n - 1,dp)
                    || subsetSum_recursive(arr, Sum - arr[n - 1], n - 1,dp);
        }
       return dp[n][Sum] = subsetSum_recursive(arr, Sum, n - 1,dp);
    }

    public boolean equalSumPartition_recursive(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][]dp = new boolean[n+1][sum/2+1];
        return subsetSum_recursive(arr, sum / 2, n,dp);
    }
    public static void main(String[] args) {
        Problem03EqualSumPartition obj = new Problem03EqualSumPartition();
        System.out.println(obj.equalSumPartition_recursive(new int[]{1,5,11,5}));
    }

}
