package com.practice.algorithms.crackingCodingInterview.P070HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates {

    public static List<Integer> removeDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if(!map.containsKey(num)){
                res.add(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            
        };
        return res;
    }

}
