package com.practice.algorithms.stack;

import java.util.Arrays;

public class P02NearestGreaterToRight2 {

    // this is a brute force solution using 2 loops 
    // to handle out of bound run loop 2*n times and mod the value with length
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
            int j = i+1;
            while ((j % nums.length) != i) {
                if (nums[j% nums.length] > nums[i]) {
                    ans[i] = nums[j% nums.length];
                    break;
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P02NearestGreaterToRight2 obj = new P02NearestGreaterToRight2();
        System.out.println(Arrays.toString(obj.nextGreaterElements(new int[] {1,2,1})));
        System.out.println(Arrays.toString(obj.nextGreaterElements(new int[] {1,2,3,4,3})));
    }
}
