package com.practice.algorithms.stack;

import java.util.Arrays;

public class P01NearestGreatetoRight {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            for (int j = i; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P01NearestGreatetoRight obj = new P01NearestGreatetoRight();

        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
        // output: [-1,3,-1]
    }
}
