package com.practice.algorithms.binarySearch;

// search element k in nearly sorted array
//nearly sorted me element will be present at most 
public class P07SearchInNearlySortedArray {

    public int search(int[] nums, int k) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == k) {
                return mid;
            } 
            if (mid > 0 && nums[mid - 1] == k) {
                return mid - 1;
            } 
            if (mid < n - 1 && nums[mid + 1] == k) {
                return mid + 1;
            } 
             if (nums[mid] > k) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P07SearchInNearlySortedArray obj = new P07SearchInNearlySortedArray();
        System.out.println(obj.search(new int[] { 10, 3, 40, 20, 50, 80, 70 }, 40));
    }

}
