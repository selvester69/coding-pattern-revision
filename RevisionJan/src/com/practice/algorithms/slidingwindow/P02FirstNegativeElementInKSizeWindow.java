package com.practice.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P02FirstNegativeElementInKSizeWindow {

    public int[] firstNegInt_brute(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {// keep in mind that n-k+1 subarrays are present in outer loop
                                                    // therefore = is imp
            int negative = 0;
            for (int j = i; j < i + k; j++) {
                if (nums[j] < 0) {
                    negative = nums[j];
                    break;
                }
            }
            res.add(negative);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] firstNegInt(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        Queue<Integer> q = new LinkedList<>();

        while (j < nums.length) {
            if (nums[j] <= 0) {
                q.add(nums[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                int num = q.size() > 0 ? q.peek() : 0;
                res.add(num);
                if (nums[i] == num) {
                    q.remove();
                }
                i++;
                j++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        P02FirstNegativeElementInKSizeWindow obj = new P02FirstNegativeElementInKSizeWindow();
        System.out.println(Arrays.toString(obj.firstNegInt_brute(new int[] { -8, 2, 3, -6, 1 }, 2)));
        System.out.println(Arrays.toString(obj.firstNegInt(new int[] { -8, 2, 3, -6, 1 }, 2)));
    }

}
