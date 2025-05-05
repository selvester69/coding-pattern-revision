package com.practice.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class P09MinimumWindowSubstring {

    public String minWindow(String s, String p) {
        String ans = "";
        int length = Integer.MAX_VALUE;
        // traverse p and store in map
        Map<Character, Integer> mapP = new HashMap<>();
        for (char c : p.toCharArray()) {
            mapP.put(c, mapP.getOrDefault(c, 0) + 1);
        }

        int count = mapP.size();
        int i = 0, j = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            mapS.put(c, mapP.getOrDefault(c, 0) + 1);
            if (mapP.containsKey(c)) {
                if (mapP.get(c) > 0) {
                    count--;
                }
                mapP.put(c, mapP.get(c) - 1);
            }
            while (count == 0) {
                if (j - i + 1 < length) {
                    length = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
                if (mapP.containsKey(s.charAt(i))) {
                    mapP.put(s.charAt(i), mapP.get(s.charAt(i)) + 1);
                    if (mapP.get(s.charAt(i)) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        P09MinimumWindowSubstring obj = new P09MinimumWindowSubstring();
        System.out.println(obj.minWindow("timetopractice", "toc"));
    }

}
