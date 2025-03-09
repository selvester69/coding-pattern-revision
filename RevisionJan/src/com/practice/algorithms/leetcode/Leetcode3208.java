package com.practice.algorithms.leetcode;

public class Leetcode3208 {

    public int numberOfAlternatingGroup_(int nums[], int k) {
        // try self by single pass solution
        // TODO: TRY
        return 0;
    }

    // time limit exceeded error
    public int numberOfAlternatingGroup(int nums[], int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isAlternate(nums, i, k)) {
                count++;
            }
        }
        return count;
    }

    public boolean isAlternate(int[] nums, int start, int k) {
        for (int i = start; i < (start + k - 1); i++) {
            if (nums[i % nums.length] == nums[(i + 1) % nums.length]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode3208 obj = new Leetcode3208();
        System.out.println(obj.numberOfAlternatingGroup(new int[] { 0, 1, 0, 1, 0 },
                3));// output 3
        System.out.println(obj.numberOfAlternatingGroup(new int[] { 0, 1, 0, 0, 1, 0,
                1 }, 6));// 2
        System.out.println(obj.numberOfAlternatingGroup(new int[] { 0, 0, 1 }, 3));// 1
        System.out.println(obj.numberOfAlternatingGroup(new int[] { 1, 1, 0, 1 },
                4));// 0
    }

}
