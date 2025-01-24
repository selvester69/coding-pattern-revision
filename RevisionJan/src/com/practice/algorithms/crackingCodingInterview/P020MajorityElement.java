package com.practice.algorithms.crackingCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class P020MajorityElement {

    // efficient way O(N) time and O(1) space
    public static int majorityElement_1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int el = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == el) {
                count++;
            } else {
                count--;
                if (count < 1) {
                    el = nums[i];
                    count = 1;
                }
            }
        }
        return el;
    }

    // optimized with O(N) space
    public static int majorityElement(int[] nums) {
        int el = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                el = nums[i];
                break;
            }
        }
        if (el == 0)
            return -1;
        else
            return el;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (majorityElement(new int[] { 3, 2, 3 }) == 3));
        System.out.println("Test Case 2: " + (majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }) == 2));
        System.out.println("Test Case 3: " + (majorityElement(new int[] { 1, 1, 1, 2, 3, 1 }) == 1));
        System.out.println("Test Case 4: " + (majorityElement(new int[] { 6, 6, 6, 7, 7 }) == 6));
        System.out.println("Test Case 5: " + (majorityElement(new int[] { 4, 4, 4, 4 }) == 4));
        System.out.println("Test Case 6: " + (majorityElement(new int[] { 8, 8, 9, 8, 10, 8, 8 }) == 8));
    }

}
