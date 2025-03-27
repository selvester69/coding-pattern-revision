package com.practice.algorithms.binarySearch;

public class P11FindPositionInInfiniteArray {

    public int findPosition(int[] nums, int k) {
        int start = 0, end = 1;
        // since array ize is infinite we can not direclty calculate end value
        int value = nums[0];
        while (value < k) {
            start = end;
            end = end * 2;
            value = nums[end];
        }
        //appply binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == k) {
                return mid;
            } else if (nums[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
