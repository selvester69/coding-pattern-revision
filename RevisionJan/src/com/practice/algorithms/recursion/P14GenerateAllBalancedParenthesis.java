package com.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * given input n generate all balenced parenthesis.
 */
public class P14GenerateAllBalancedParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        recur(n, 0, 0, "", res);
        return res;
    }

    public void recur(int n, int open, int close, String op, List<String> res) {
        if (open == n && close == n) {
            res.add(op);
            return;
        }
        if (open < n) {
            recur(n, open + 1, close, op + "(", res);
        }
        if (close < open) {
            recur(n, open, close + 1, op + ")", res);
        }
    }

    public static void main(String[] args) {
        P14GenerateAllBalancedParenthesis obj = new P14GenerateAllBalancedParenthesis();
        System.out.println(obj.generateParenthesis(2));
        System.out.println(obj.generateParenthesis(3));
    }
}
