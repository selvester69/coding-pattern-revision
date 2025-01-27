package com.practice.algorithms.crackingCodingInterview;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P044ValidParenthesis {

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{')
                        || (c == ']' && stack.peek() == '['))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        test("()", true);
        test("()[]{}", true);
        test("(]", false);
        test("([)]", false);
        test("{[]}", true);
        test("", true);
        test("(", false);
        test("]", false);
        test("((", false);
        test("))", false);
        test("){", false);
        test("[(])", false);
        test(null, false);
        test("){", false);
        test("([{}])", true);
        test("(([]){})", true);
        test("]", false);
        test("[[", false);
        test("}{", false);

    }

    private static void test(String s, boolean expected) {
        boolean actual = isValid(s);
        if (actual == expected) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("Input: " + s);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        System.out.println("---------------");
    }
}
