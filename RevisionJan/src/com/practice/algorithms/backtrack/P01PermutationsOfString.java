package com.practice.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class P01PermutationsOfString {
    // recursive Solution
    public List<List<String>> permute(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s, "");
        return res;
    }

    public void solve(String input, String output) {
        if (input == null || input.length() == 0) {
            System.out.println(output);
        }
        for (int i = 0; i < input.length(); i++) {
            // swap
            String newIP = input.substring(0, i) + input.substring(i + 1);
            String newOP = output + input.charAt(i);
            solve(newIP, newOP);
            // swap back
        }
    }

    public void backTrackSolution(String s) {
        solve_bt(new StringBuilder(s), 0);
    }

    public void solve_bt(StringBuilder input, int index) {
        if (index == input.length()) {
            System.out.println(input);
        }
        for (int i = index; i < input.length(); i++) {
            // swap
            swap(index, i, input);
            solve_bt(input, index + 1);
            swap(index, i, input);
            // swap reverse
        }
    }

    public void swap(int index, int i, StringBuilder s) {
        char temp = s.charAt(index);
        s.setCharAt(index, s.charAt(i));
        s.setCharAt(i, temp);
    }

    public static void main(String[] args) {
        P01PermutationsOfString obj = new P01PermutationsOfString();
        System.out.println(obj.permute("abc"));
        obj.backTrackSolution("abc");
        //in case of repeated chars use set to reduce duplicates.
        
    }

}
