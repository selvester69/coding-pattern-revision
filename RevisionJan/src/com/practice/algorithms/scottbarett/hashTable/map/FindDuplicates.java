package com.practice.algorithms.scottbarett.hashTable.map;

import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 1, 4, 5, 4 };
        // List<Integer> duplicates = findDuplicates(nums);
        List<Integer> duplicates = findDuplicates_2(nums);
        System.out.println(duplicates);

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * [1, 2, 4]
         * 
         */
    }

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                res.add(i);
            }
            set.add(i);
        }
        return res;
    }

    static List<Integer> findDuplicates_2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> keys : map.entrySet()){
            if(keys.getValue()>1){
                res.add(keys.getKey());
            }
        }
        return res;
    }
}
