package com.practice.algorithms.slidingwindow;

public class P01MaxSumSubarraySizek {

    public long maximumSubarraySum_brute(int[] nums, int k) {
        long maxSum = 0;
        for (int i = 0; i <= nums.length - k; i++) {// keep in mind that n-k+1 subarrays are present in outer loop therefore = is imp
            long sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // optimize using sliding window
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        int i = 0, j = 0;
        long sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - nums[i];
                i++;//decrease window
            }
            j++;//increase window 
        }
        return maxSum;
    }

    /**
     * for understanding purpose
     * public long maximumSubarraySum(int[] nums, int k) {
     * long maxSum = 0;
     * int i = 0, j = 0;
     * long sum = 0;
     * while (j < nums.length) {
     * sum += nums[j];
     * if(j-i+1<k){- till window size is smaller
     * j++;//increment j
     * }
     * else if (j - i + 1 == k) {
     * maxSum = Math.max(maxSum, sum);
     * sum = sum - nums[i];
     * i++;// maintain window
     * j++;//maintain window
     * }
     * }
     * return maxSum;
     * }
     */

    public static void main(String[] args) {
        P01MaxSumSubarraySizek obj = new P01MaxSumSubarraySizek();
        System.out.println(obj.maximumSubarraySum_brute(new int[] { 1, 4, 2, 10, 23, 3, 1, 0, 20 }, 4));
        System.out.println(obj.maximumSubarraySum(new int[] { 1, 4, 2, 10, 23, 3, 1, 0, 20 }, 4));
    }
}
