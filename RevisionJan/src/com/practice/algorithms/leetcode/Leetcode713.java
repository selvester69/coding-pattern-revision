package com.practice.algorithms.leetcode;

public class Leetcode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int prod = nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(prod<k){
                    count++;
                }
                prod = prod*nums[j];
            }
            if(prod<k){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Leetcode713 obj = new Leetcode713();
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

}
