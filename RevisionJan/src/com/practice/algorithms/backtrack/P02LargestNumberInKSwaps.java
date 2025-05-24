package com.practice.algorithms.backtrack;

public class P02LargestNumberInKSwaps {

    public void backtrack(String s, int k) {
        solve(new StringBuilder(s), k, 0);
    }

    public void solve(StringBuilder s, int k, int index) {
        if (k == 0 || index == s.length() - 1) {
            // find larget ans
            System.out.println(s.toString());
        }

        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(index)) {
                // swap and proceed
                char temp = s.charAt(index);
                s.setCharAt(index, s.charAt(i));
                s.setCharAt(i, temp);
                // solve
                solve(s, k-1, index + 1);
                // swap back
                temp = s.charAt(index);
                s.setCharAt(index, s.charAt(i));
                s.setCharAt(i, temp);
            }
        }
    }

    public static void main(String[] args) {
        P02LargestNumberInKSwaps obj = new P02LargestNumberInKSwaps();
        obj.backtrack("4321", 4);
    }
}
