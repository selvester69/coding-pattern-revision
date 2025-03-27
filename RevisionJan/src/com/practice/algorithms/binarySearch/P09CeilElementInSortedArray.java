package com.practice.algorithms.binarySearch;

// given nums array find the ceil element for k.
// floor element is the element less than or equal to right of k.
// return the index of floor else return -1;
public class P09CeilElementInSortedArray {

    public int findCeilEmelent(int[] nums, int k) {
        int res = -1;
        int n = nums.length;
        if(nums[n-1]==k) return res;
        int start=0,end=n-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if(nums[mid]==k){
                res = mid;
            }else if(nums[mid] < k){
                start = mid+1;
            }else {
                end = mid-1;
                res = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        P09CeilElementInSortedArray obj = new P09CeilElementInSortedArray();
        System.out.println(obj.findCeilEmelent(new int[] { 1, 2, 8, 10, 10, 12, 19 }, 5));
        System.out.println(obj.findCeilEmelent(new int[] { 1, 2, 8, 10, 10, 12, 19 }, 20));
        System.out.println(obj.findCeilEmelent(new int[] { 1, 1, 2, 8, 10, 10, 12, 19 }, 0));
    }
}
