package com.practice.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode 483
public class P03CountOccuranceOfAnagram {

    // time limit exceed
    public List<Integer> findAnagrams_brute(String s, String p) {
        int k = p.length();
        Map<Character, Integer> pMap = new HashMap<>();
        int count = 0;
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (checkAnagramUtil(s.substring(i, j + 1), pMap)) {
                    res.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);// prints count
        return res;
    }

    public boolean checkAnagramUtil(String s, Map<Character, Integer> pMap) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
            if (entry.getValue() != sMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sliding window solution
     * 
     * @param s
     * @param p
     * @return
     */

    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        int count = pMap.size();// count of distinct letters.
        int i = 0, j = 0;
        while (j < s.length()) {
            // calculations
            if (pMap.containsKey(s.charAt(j))) {
                pMap.put(s.charAt(j), pMap.get(s.charAt(j)) - 1);
                if (pMap.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            //reach window size
            
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // ans from
                if (count == 0) {
                    res.add(i);
                }
                if (pMap.containsKey(s.charAt(i))) {
                    if (pMap.get(s.charAt(i)) == 0) {
                        count++;
                    }
                    pMap.put(s.charAt(i), pMap.get(s.charAt(i)) + 1);
                }
                i++;
                j++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        P03CountOccuranceOfAnagram obj = new P03CountOccuranceOfAnagram();
        System.out.println(obj.findAnagrams_brute("cbaebabacd", "abc"));
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
    }

}
