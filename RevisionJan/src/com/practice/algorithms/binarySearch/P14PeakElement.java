package com.practice.algorithms.binarySearch;

// questions based on binary search on answer concept.

public class P14PeakElement {

    public int peakElement_bruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i == 0 || nums[i - 1] < nums[i]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    public int peakElement(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid - 1] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                return nums[0] > nums[1] ? 0 : 1;

            } else if (mid == n - 1) {
                return nums[n - 1] > nums[n - 2] ? n - 1 : n - 2;

            }
        }
        return -1;
    }
    public int peakElement_anotherApproach(int[]nums){
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]>nums[1]){
            return nums[0];
        }
        if(nums[n-1]>nums[n-2]){
            return nums[n-1];
        }
        int start=0,end=n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid-1]>nums[mid+1]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

}
