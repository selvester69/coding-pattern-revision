package com.practice.algorithms.binarySearch;

/**
 * 
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 */
public class P10NextAlphabeticalElement {
    public int nextAlphabet(char[] letters, char x) {
        int res = 0;
        int n = letters.length;
        // if (letters[0] == x || letters[n - 1] == x) {
        //     return letters[0];
        // }
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
             if (letters[mid] <= x) {
                 start = mid + 1;
                } else {
                res = mid;
                // res = mid;
                end = mid - 1;
            }
        }
        if (res < 0 || res >= n) {
            // return letters[0];
            return 0;
        }
        return res;//index 
    }

    public static void main(String[] args) {
        P10NextAlphabeticalElement obj = new P10NextAlphabeticalElement();
        System.out.println(obj.nextAlphabet(new char[] { 'c', 'f', 'j' }, 'a'));
        System.out.println(obj.nextAlphabet(new char[] { 'c', 'f', 'j' }, 'c'));
        System.out.println(obj.nextAlphabet(new char[] { 'x', 'x', 'y', 'y' }, 'z'));
    }

}
