package leetcode.stack;

import java.util.Stack;

public class P14ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(P14ValidParenthesis.bruteForce("(()"));
		System.out.println(P14ValidParenthesis.bruteForce(")()())"));
		System.out.println(P14ValidParenthesis.bruteForce(""));
//		System.out.println(P14ValidParenthesis.longestValidParentheses("(()"));
//		System.out.println(P14ValidParenthesis.longestValidParentheses(")()())"));
//		System.out.println(P14ValidParenthesis.longestValidParentheses(""));
	}
	
	public static int longestValidParentheses(String s) {
		int count = 0;
        int maxCount = 0;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && c == ')' && st.peek() == '(') {
                st.pop();
                count += 2;
                maxCount = Math.max(count, maxCount);
            } else {
                st.push(c);
            }
        }
        return maxCount;
	}
	
	public static int bruteForce(String s) {
		int maxCount=0;
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(isValid(s.substring(i, j+1))) {
					maxCount = Math.max(maxCount, j-i+1);
				}
			}
		}
		return maxCount;
	}
	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		for(char c:s.toCharArray()) {
			if (!st.isEmpty() && c == ')' && st.peek() == '(') {
                st.pop();
            } else {
                st.push(c);
            }
		}
		return st.isEmpty();
	}
	
}
