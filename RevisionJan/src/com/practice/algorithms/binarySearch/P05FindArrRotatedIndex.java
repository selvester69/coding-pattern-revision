package com.practice.algorithms.binarySearch;

// Q: find index of rotation in sorted rotated array.
public class P05FindArrRotatedIndex {

    public int search(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
                return mid;
            } else if (nums[mid] > nums[end]) {// right side is unsorted we have to move to right
                start = mid + 1;
            } else {
                end = mid - 1; // left side is unsorted we have to move to left
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 11, 12, 15, 18, 2, 5, 6, 8 };
        P05FindArrRotatedIndex obj = new P05FindArrRotatedIndex();
        System.out.println(obj.search(nums));
    }
}
