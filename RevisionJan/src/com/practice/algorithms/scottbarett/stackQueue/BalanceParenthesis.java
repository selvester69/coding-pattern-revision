package com.practice.algorithms.scottbarett.stackQueue;

public class BalanceParenthesis extends Stack<Character> {

    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }

    private static boolean isBalancedParentheses(String testStr) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < testStr.length(); i++) {
            char ch = testStr.charAt(i);
            if ((ch ==')')&& !st.isEmpty()) {
                if((st.peek()=='(')){
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        return st.isEmpty();
    }

}
