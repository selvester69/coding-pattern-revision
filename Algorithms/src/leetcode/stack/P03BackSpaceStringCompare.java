package leetcode.stack;

import java.util.Stack;

public class P03BackSpaceStringCompare {

	public static void main(String[] args) {
		System.out.println(P03BackSpaceStringCompare.backspaceCompare("ab#c", "ad#c"));
		System.out.println(P03BackSpaceStringCompare.backspaceCompare("ab##", "c#d#"));
		System.out.println(P03BackSpaceStringCompare.backspaceCompare("a#c", "b"));
	}
	
	public static boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                st1.push(c);
            } else {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }
        }
        for (char c : t.toCharArray()) {
            if (c != '#') {
                st2.push(c);
            } else {
                if (!st2.isEmpty()) {
                    st2.pop();

                }
            }
        }
        if (st1.size() == st2.size()) {
            boolean isTrue = true;
            while (st1.size() > 0 && st2.size() > 0) {
                isTrue = st1.pop() == st2.pop();
            }
            return isTrue;
        }
        return false;
    }
}
