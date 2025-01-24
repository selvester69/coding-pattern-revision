package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P018MergeSort {

    public static int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int[] res = new int[nums1.length + nums2.length];
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            res[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[k++] = nums2[j++];
        }

        return res;
    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length == 1)
            return nums;

        int n = nums.length;
        int mid = n / 2;
        int[] first = new int[mid];
        int[] second = new int[n - mid];
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < first.length; i++) {
            first[firstIndex++] = nums[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[secondIndex++] = nums[mid + i];
        }
        int res1[] = mergeSort(first);
        int res2[] = mergeSort(second);
        int res[] = merge(res1, res2);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[] { 3, 5, 7, 9, 1, 2, 4, 6, 8, 0 };
        int res[] = mergeSort(nums);
        System.out.println(Arrays.toString(res));

    }

}
