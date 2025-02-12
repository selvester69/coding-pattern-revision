package com.practice.algorithms.crackingCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class P067TwoSum {
public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            } 
                map.put((nums[i]), i);
        }
        return res;
    }
}
