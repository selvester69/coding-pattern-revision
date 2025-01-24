package com.practice.algorithms.crackingCodingInterview;

public class P027SingleNumber {

    public static int singleNUmber(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNUmber(new int[]{4,1,2,1,2}));
    }

}
