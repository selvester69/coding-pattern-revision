package leetcode.stack;
import java.util.*;;

public class P01ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(P01ValidParenthesis.isValid("()")+" true");
        System.out.println(P01ValidParenthesis.isValid("()[]{}")+" true");
        System.out.println(P01ValidParenthesis.isValid("(]")+" false");
        System.out.println(P01ValidParenthesis.isValid("([])")+" true");
        System.out.println(P01ValidParenthesis.isValid("]")+" false");

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                // handle Edge case for stack size zero
                if (stack.size() > 0 && ((c == ')' && stack.peek() == '(') ||
                        (c == ']' && stack.peek() == '[') ||
                        (c == '}' && stack.peek() == '{'))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size() == 0;
    }

}
