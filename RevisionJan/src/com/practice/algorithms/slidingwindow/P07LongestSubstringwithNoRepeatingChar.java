package com.practice.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P07LongestSubstringwithNoRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int longest = 0;
        int i = 0, j = 0;
        // use sliding window
        while (j < s.length()) {
            // calculations
            char c = s.charAt(j);
            if (!hs.contains(c)) {
                hs.add(c);
                longest = Math.max(longest, j - i + 1);
                j++;
            } else if (hs.contains(c)) {
                // ans from calcualtions
                while (hs.contains(c) && hs.size() > 0) {
                    hs.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return longest;
    }

    // another approach using map and previous question of k unique characters
    public int lengthOfLongestSubstring_map(String s) {
        int longest = 0;
        Map<Character, Integer> hm = new HashMap<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            // calculations
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
             if (hm.size() == (j - i + 1)) {
                longest = Math.max(longest, j - i + 1);
            } else if(hm.size() < (j - i + 1)) {//in case of duplicate characters map size will be less than window size
                while (hm.size() < (j - i + 1)) {
                    if (hm.get(s.charAt(i)) > 0) {
                        hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                        if (hm.get(s.charAt(i)) == 0) {
                            hm.remove(s.charAt(i));
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
        P07LongestSubstringwithNoRepeatingChar obj = new P07LongestSubstringwithNoRepeatingChar();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
       
        System.out.println(obj.lengthOfLongestSubstring_map("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring_map("abcabcbb"));
    }
}
