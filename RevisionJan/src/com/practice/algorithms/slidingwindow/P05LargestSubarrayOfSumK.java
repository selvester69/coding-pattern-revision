package com.practice.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// problem for variable size sliding window.
public class P05LargestSubarrayOfSumK {
    // here window size is not given but we need to find the window size.
    // window size is j-i+1 ;

    // brute force
    public int brute(int[] nums, int k) {
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    public int longestSubarrayWithSumK(int[] nums, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int longest = 0;
        while (j < nums.length) {
            // calculations
            sum += nums[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                // get ans from calcualtions
                longest = Math.max(longest, j - i + 1);
                // slide the window
                // before sliding remove nums[i];
                j++;
            } else if(sum>k) {
                while (sum > k && i<j) {
                    sum -= nums[i];
                    i++;
                }
                if(sum==k){
                    longest = Math.max(longest, j - i + 1);
                }
                j++;
            }
        }
        return longest;
    }

    public int longestSubarrayWithSumK_prefixApproach(int[] nums, int k){
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int longest = 0;

        prefixSumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - k)) {
                longest = Math.max(longest, i - prefixSumMap.get(sum - k));
            }

            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        P05LargestSubarrayOfSumK obj = new P05LargestSubarrayOfSumK();
        System.out.println(obj.brute(new int[] { 1, 1, 1 }, 3));
        System.out.println(obj.brute(new int[] { 10, 5, 2, 7, 1, -10 }, 15));
        System.out.println("optimized approach");
        System.out.println(obj.longestSubarrayWithSumK(new int[] { 1, 1, 1 }, 3));
        System.out.println(obj.longestSubarrayWithSumK(new int[] { 10, 5, 2, 7, 1, -10 }, 15));// ans should be 6 but current ans is 4 
        // this is because this approach only handles positive number and does not work with negative numbers.
        //use hashmap and prefix sum approach for correct result.
        System.out.println("prefix approach");
        System.out.println(obj.longestSubarrayWithSumK_prefixApproach(new int[] { 10, 5, 2, 7, 1, -10 }, 15)); 
    }

}
