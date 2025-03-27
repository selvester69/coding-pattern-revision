package com.practice.algorithms.binarySearch;

// given nums array find the floor element for k.
// floor element is the element greater than or equal to left of k.
// return the index of floor else return -1;
public class P08FloorElementInSortedArray {

    // using binary search to find in o(log n) time
    public int findFloorElement(int[] nums, int k) {
        int n = nums.length;
        int start = 0, end = n - 1;
        if (nums[0] == k)
            return -1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == k) {
                res = mid;
            } else if (nums[mid] < k) {
                res = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 8, 10, 10, 12, 19 };
        P08FloorElementInSortedArray obj = new P08FloorElementInSortedArray();
        System.out.println(obj.findFloorElement(nums, 5));//1
        System.out.println(obj.findFloorElement(new int[]{1, 2, 8, 10, 10, 12, 19}, 20));//6
        System.out.println(obj.findFloorElement(new int[]{1, 2, 8, 10, 10, 12, 19}, 0));//-1
    }

}
