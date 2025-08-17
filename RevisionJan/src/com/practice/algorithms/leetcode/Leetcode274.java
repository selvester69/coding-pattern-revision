package com.practice.algorithms.leetcode;

import java.util.Arrays;

public class Leetcode274 {

    public static int hIndex(int[] nums) {
        int length = nums.length;
        int[]arr = new int[length+1];
        for(int i:nums){
            arr[Math.min(length, i)]++;
        }
        System.out.println(Arrays.toString(arr));
        int cul=0;
        for (int i = length; i > 0; i--) {
            cul+=arr[i];
            if(cul>=i){
                return cul;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));
    }

}
