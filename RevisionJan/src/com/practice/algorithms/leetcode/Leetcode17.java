package com.practice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    Map<String, List<String>> digitMap = Map.ofEntries(
            Map.entry("2", List.of("a", "b", "c")),
            Map.entry("3", List.of("d", "e", "f")),
            Map.entry("4", List.of("g", "h", "i")),
            Map.entry("5", List.of("j", "k", "l")),
            Map.entry("6", List.of("m", "n", "o")),
            Map.entry("7", List.of("p", "q", "r", "s")),
            Map.entry("8", List.of("t", "u", "v")),
            Map.entry("9", List.of("w", "x", "y", "z")));

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, res, "");
        // printAllMapValues();
        return res;
    }

    public void backtrack(String digits, int index, List<String> res, String op) {
        if (index == digits.length()) {
            res.add(op);
            return;
        }
            List<String> letters = digitMap.get(String.valueOf(digits.charAt(index)));
            for (int j = 0; j < letters.size(); j++) {
                String op1 = op + letters.get(j);
                backtrack(digits, index + 1, res, op1);
                op1 = op1.substring(0, op1.length());
            }
    }
    public static void main(String[] args) {
        Leetcode17 obj = new Leetcode17();
        List<String> res = obj.letterCombinations("23");
        System.out.println(res);
    }
}
