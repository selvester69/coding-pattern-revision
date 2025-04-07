package com.practice.algorithms.binarySearch;

public class P18AllocatePagesInBook {

    public int bruteForce(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return -1;
        }
        int max = Integer.MIN_VALUE, sum = 0;
        for (int s : nums) {
            sum += s;
            max = Math.max(max, s);
        }
        for (int i = max; i <= sum; i++) {
            int st = countStudent(nums, n, k, i);
            if (st == k) {
                return i;
            }
        }
        return max;
    }

    private int countStudent(int[] nums, int n, int k, int max) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > max) {
                student++;
                sum = nums[i];
            }
        }
        return student;
    }

    public int allocatePages(int[] nums, int k) {

        int n = nums.length;
        if (n < k)
            return -1; // number of books are less than number of students.
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int s : nums) {
            sum += s;
            if (s > max) {
                max = s;
            }
        }
        int res = -1;
        int start = max, end = sum;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(nums, n, k, mid)) {
                res = mid;// possible answer
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private boolean isValid(int[] nums, int n, int k, int max) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > max) {
                student++;
                sum = nums[i];
            }
            if (student > k) {
                return false;
            }
        }

        return true;
    }

}
