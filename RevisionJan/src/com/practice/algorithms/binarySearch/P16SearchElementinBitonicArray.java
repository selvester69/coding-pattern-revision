package com.practice.algorithms.binarySearch;

import java.util.HashMap;
import java.util.Map;

public class P16SearchElementinBitonicArray {

    // oonly way to solve is
    // 1. find peak element findIndex
    // 2. find el in increasing array
    // 3. find element int desreasing array

    public int searchInBitonic(int target, int[] nums) {
        int start = 0, end = nums.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        int peak = findPeak(nums, map);
        int inc = bsOnInc(target, nums, start, peak - 1);
        if (inc != -1)
            return inc;
        int desc = bsOnDesc(target, nums, peak, end);
        if (desc != -1)
            return desc;
        return -1;
    }

    public int findPeak(int[] nums, Map<Integer, Integer> map) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int bsOnInc(int target, int[] nums, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return bsOnInc(target, nums, start, mid - 1);
        } else {
            return bsOnInc(target, nums, mid + 1, end);
        }
    }

    public int bsOnDesc(int target, int[] nums, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return bsOnDesc(target, nums, start, mid - 1);
        } else {
            return bsOnDesc(target, nums, mid + 1, end);
        }
    }

}
