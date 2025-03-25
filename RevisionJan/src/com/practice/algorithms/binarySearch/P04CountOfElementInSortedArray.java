package com.practice.algorithms.binarySearch;

public class P04CountOfElementInSortedArray {

    // approach find lower and upper index of the element using above problem and
    // find the count by subtracting them.

    public int countOccurance(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return last - first + 1;
    }

    public int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return res;
    }

    public int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 10, 10, 10, 18, 20 };
        int target = 10;
        P04CountOfElementInSortedArray obj = new P04CountOfElementInSortedArray();
        System.out.println(obj.countOccurance(nums, target));
    }

}
