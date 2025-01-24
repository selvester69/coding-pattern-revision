package com.practice.algorithms.crackingCodingInterview;

public class P023SearchInSortedRotatedArray {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                // left side is sorted
                // check if tagret is on sorted side
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right side is sorted
                // check if target on sorted side
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0) == 4));
        System.out.println("Test Case 2: " + (search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3) == -1));
        System.out.println("Test Case 3: " + (search(new int[] { 1 }, 0) == -1));
        System.out.println("Test Case 4: " + (search(new int[] { 1 }, 1) == 0));
        System.out.println("Test Case 5: " + (search(new int[] {  1, 3 }, 3) == 1));
        System.out.println("Test Case 6: " + (search(new int[] { 5, 1, 3 }, 5) == 0));
        System.out.println("Test Case 7: " + (search(new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 3) == 5));
        System.out.println("Test Case 8: " + (search(new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 6) == 0));
        System.out.println("Test Case 9: " + (search(new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 5) == 7));
    }

}
