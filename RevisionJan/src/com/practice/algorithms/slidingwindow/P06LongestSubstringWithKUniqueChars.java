package com.practice.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class P06LongestSubstringWithKUniqueChars {

    public int uniqueChars(String s, int k) {
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        while (j < n) {
            // calculation
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() == k) {
                // ans-> calcualtion
                longest = Math.max(longest, j - i + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    // remove i calcualations and i++;
                    if (map.get(s.charAt(i)) > 0) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                        if (map.get(s.charAt(i)) == 0) {
                            map.remove(s.charAt(i));
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return longest;
    }

    public static void main(String[] args) {
        P06LongestSubstringWithKUniqueChars obj = new P06LongestSubstringWithKUniqueChars();
        System.out.println(obj.uniqueChars("aabacbebebe", 3));
    }

}
