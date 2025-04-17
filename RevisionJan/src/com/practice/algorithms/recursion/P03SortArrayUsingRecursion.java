package com.practice.algorithms.recursion;

import java.util.Arrays;

public class P03SortArrayUsingRecursion {

    public void sort(int[] nums) {
        rec(nums, nums.length);
    }
    public void rec(int[]nums, int index){
        //base condition
        if(index<=1) return;
        //hypothesis
        rec(nums, index-1);
        // induction
        int temp = nums[index-1];
        int tempIndex = index-2;
        while(tempIndex>=0 && nums[tempIndex]>temp){
            //swap if greater
            nums[tempIndex+1] = nums[tempIndex];
            tempIndex--;
        }
        nums[tempIndex+1] = temp;
    }

    public static void main(String[] args) {
        P03SortArrayUsingRecursion obj = new P03SortArrayUsingRecursion();
        int[] nums = { 5, 4, 3, 2, 1 };
        obj.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
