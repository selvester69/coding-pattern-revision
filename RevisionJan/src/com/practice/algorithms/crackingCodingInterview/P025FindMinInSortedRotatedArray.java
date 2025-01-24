package com.practice.algorithms.crackingCodingInterview;

public class P025FindMinInSortedRotatedArray {

    public static int findMin(int[] nums) {
        if (nums.length == 0)
            return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[end]) {
                return nums[start];
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }

}
