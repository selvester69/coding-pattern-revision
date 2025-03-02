package com.practice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int i=0,j=0;
        // till both values match
        while (i < m && j < n) {
            if (nums1[i][0] < nums2[j][0]) {
                res.add(new int[] { nums1[i][0], nums1[i][1] });
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                res.add(new int[] { nums2[j][0], nums2[j][1] });
                j++;
            } else {
                // sum both values
                res.add(new int[] { nums1[i][0], (nums1[i][1] + nums2[j][1]) });
                i++;
                j++;
            }
        }
        while (i < m) {
            res.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }
        while (j < n) {
            res.add(new int[] { nums2[j][0], nums2[j][1] });
            j++;
        }
        int[][] ans = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        Leetcode2570 obj = new Leetcode2570();
        int[][] ans = obj.mergeArrays(nums1, nums2);
        for (int[] is : ans) {
            System.out.println(is[0] + " " + is[1]);
        }
    }

}
