package com.practice.algorithms.binarySearch;

// Q: find minimum element in sorted rotated array.
public class P06FindMinElementInArray {

    public int minEl(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
                return mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
    public static void main(String[] args) {
        int[] nums = { 11, 12, 15, 18, 1, 5, 6, 8 };
        P06FindMinElementInArray obj = new P06FindMinElementInArray();
        System.out.println(obj.minEl(nums));
    }
}
