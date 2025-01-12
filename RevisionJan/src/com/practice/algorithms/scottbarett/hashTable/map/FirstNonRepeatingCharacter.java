package com.practice.algorithms.scottbarett.hashTable.map;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * l
         * h
         * null
         * 
         */

    }

    private static Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return null;
    }

}
