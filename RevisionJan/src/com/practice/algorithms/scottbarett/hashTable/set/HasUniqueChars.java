package com.practice.algorithms.scottbarett.hashTable.set;

import java.util.HashSet;
import java.util.Set;

public class HasUniqueChars {

    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * true
         * false
         * true
         * true
         * false
         * 
         */

    }

    private static boolean hasUniqueChars(String string) {
        Set<Character> set = new HashSet<>();
        for(char c: string.toCharArray()){
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

}
