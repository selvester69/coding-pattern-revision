package com.practice.algorithms.binarySearch;

// find min diff element in sorted array give key 
// if key is present and key not present.
// ty
public class P13MinDifferenceElementInSortedArr {

    // therefore to solve we can find floor of element and ceil of element and
    // compare whichever is lower.
    public int bruteForce(int[] nums, int key) {
        int min = nums[0];
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(key - nums[i]) < min) {
                min = Math.abs(key - nums[i]);
                minIndex = i;
            }
        }
        return minIndex;
    }

    // since sorted array is given try with binary sort
    public int midDiff_Type1(int[] nums, int key) {
        int n = nums.length;
        int start = 0, end = n - 1;
        // check difference with floor element
        int floor=0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return mid;
            }else if(nums[mid]<key){
                floor = mid;
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        // check difference with ceil element
        int ceil=0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return mid;
            }else if(nums[mid]<key){
                start = mid+1;
            }else {
                ceil = mid;
                end = mid-1;
            }
        }
        if(Math.abs(nums[floor]-key)< Math.abs(nums[ceil]-key)){
            return floor;
        }else {
            return ceil;
        }
    }
}
