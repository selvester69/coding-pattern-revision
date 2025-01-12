package com.practice.algorithms.scottbarett.hashTable.map;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[] { "abc", "cba", "bac", "foo", "bar" }));

        System.out.println("\n3rd set:");
        System.out.println(
                groupAnagrams(new String[] { "listen", "silent", "triangle", "integral", "garden", "ranged" }));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * 1st set:
         * [[eat, tea, ate], [tan, nat], [bat]]
         * 
         * 2nd set:
         * [[abc, cba, bac], [foo], [bar]]
         * 
         * 3rd set:
         * [[listen, silent], [triangle, integral], [garden, ranged]]
         * 
         */

    }

    private static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String str : strings) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String newString = new String(c);
            hm.putIfAbsent(newString, new ArrayList<>());
            hm.get(newString).add(str);
        }
        return new ArrayList<>(hm.values());
    }

}
