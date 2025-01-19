package com.practice.algorithms.crackingCodingInterview;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P04ReversePolishNotation {

    // basic brute force approach is to use stack and calculate the result.
    public static int evalRPNApproach(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        String operands = "+-*/";
        while (i < tokens.length) {
            if (operands.contains(tokens[i])) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(calculate(op1, op2, tokens[i]));
            } else
                stack.push(Integer.parseInt(tokens[i]));
            i++;
        }
        return stack.pop();
    }

    private static int calculate(int op1, int op2, String string) {
        int res = 0;
        switch (string) {
            case "+":
                res = op1 + op2;
                break;
            case "-":
                res = op2 - op1;
                break;

            case "*":
                res = op2 * op1;
                break;

            case "/":
                res = op2 / op1;
                break;
        }
        return res;
    }

    // efficient approach is to optimize O(N) space to use use O(1) to use 2 pointer
    // public int evalRPNApproach_2(String[] tokens) {

    // }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (evalRPNApproach(new String[] { "2", "1", "+", "3", "*" }) == 9)); // (2 +
                                                                                                                // 1) *
                                                                                                                // 3 = 9
        System.out.println("Test Case 2: " + (evalRPNApproach(new String[] { "4", "13", "5", "/", "+" }) == 6)); // 4 +
                                                                                                                 // (13
                                                                                                                 // / 5)
                                                                                                                 // = 6
        System.out.println("Test Case 3: "
                + (evalRPNApproach(new String[] { "10", "6", "9", "3", "/", "-", "*", "11", "+" }) == 41)); // Complex
                                                                                                           // case
        System.out.println("Test Case 4: " + (evalRPNApproach(new String[] { "0", "3", "/" }) == 0)); // 0 divided by 3
                                                                                                      // = 0
        System.out.println("Test Case 5: " + (evalRPNApproach(new String[] { "3", "-4", "+" }) == -1)); // 3 + (-4) = -1
        System.out.println(
                "Test Case 6: " + (evalRPNApproach(new String[] { "100", "200", "+", "2", "/", "5", "*" }) == 750)); // ((100
                                                                                                                     // +
                                                                                                                     // 200)
                                                                                                                     // /
                                                                                                                     // 2)
                                                                                                                     // *
                                                                                                                     // 5
                                                                                                                     // =
                                                                                                                     // 750
        System.out
                .println("Test Case 7: " + (evalRPNApproach(new String[] { "3", "3", "*", "2", "1", "+", "/" }) == 3)); // (3
                                                                                                                        // *
                                                                                                                        // 3)
                                                                                                                        // /
                                                                                                                        // (2
                                                                                                                        // +
                                                                                                                        // 1)
                                                                                                                        // =
                                                                                                                        // 4
        System.out.println("Test Case 8: " + (evalRPNApproach(new String[] { "5", "6", "-", "7", "+" }) == 6)); // (5 -
                                                                                                                // 6) +
                                                                                                                // 7 = 6
        System.out.println("Test Case 9: " + (evalRPNApproach(new String[] { "5", "1", "/", "2", "+" }) == 7)); // 5 / 1
                                                                                                                // + 2 =
                                                                                                                // 7
        System.out.println("Test Case 10: " + (evalRPNApproach(new String[] { "5" }) == 5)); // Single number
    }

}
