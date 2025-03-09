package com.practice.algorithms.leetcode;

public class Leetcode2379 {

    public int minRecolors(String blocks, int k) {
        int i = 0, j = 0, min = Integer.MAX_VALUE, count = 0;
        while (j < blocks.length()) {
            if (blocks.charAt(j) == 'W') {
                count++;
            }
            if (j - i + 1 == k) {
                // System.out.println(blocks.substring(i, j+1));
                min = Math.min(min, count);
                if (blocks.charAt(i) == 'W') {
                    count--;
                }
                i++;
            }
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        Leetcode2379 obj = new Leetcode2379();
        System.out.println(obj.minRecolors("WBBWWBBWBW", 7));
        System.out.println(obj.minRecolors("WBWBBBW", 2));
    }
}
