package com.practice.algorithms.stack;

import java.util.ArrayList;
import java.util.List;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P10MinimumStackExtraSapce {
    Stack<Integer> st;
    Stack<Integer> min;

    public P10MinimumStackExtraSapce() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty() && min.isEmpty()) {
            st.push(val);
            min.push(val);
        }
        if (val <= min.peek()) {
            min.push(val);
        }
        st.push(val);
    }

    public void pop() {
        int el = st.pop();
        if (el == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        P10MinimumStackExtraSapce minStack = new P10MinimumStackExtraSapce();
        List<String> operations = List.of("MinStack", "push", "push", "push", "top", "pop", "getMin", "pop", "getMin",
                "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin");
        List<Integer[]> values = List.of(
                new Integer[] {},
                new Integer[] { 2147483646 },
                new Integer[] { 2147483646 },
                new Integer[] { 2147483647 },
                new Integer[] {},
                new Integer[] {},
                new Integer[] {},
                new Integer[] {},
                new Integer[] {},
                new Integer[] {},
                new Integer[] { 2147483647 },
                new Integer[] {},
                new Integer[] {},
                new Integer[] { -2147483648 },
                new Integer[] {},
                new Integer[] {},
                new Integer[] {},
                new Integer[] {});
        List<String> expectedResults = List.of(
                "null",
                "null",
                "null",
                "null",
                "2147483647",
                "2147483647",
                "2147483646",
                "2147483646",
                "2147483646",
                "2147483646",
                "null",
                "2147483647",
                "2147483647",
                "null",
                "-2147483648",
                "-2147483648",
                "-2147483648",
                "2147483647" // Assuming getMin after popping the last min returns the previous min or -1 if
                             // empty
        );
//[null,null,null,null,
//2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
        List<String> actualResults = new ArrayList<>();
        actualResults.add(null); // For the constructor

        for (int i = 1; i < operations.size(); i++) {
            String operation = operations.get(i);
            Integer[] value = values.get(i);

            switch (operation) {
                case "push":
                    minStack.push(value[0]);
                    actualResults.add(null);
                    break;
                case "pop":
                    minStack.pop();
                    actualResults.add("");
                    break;
                case "top":
                    actualResults.add(minStack.st.peek() + ""); // Accessing st.peek() directly for testing
                    break;
                case "getMin":
                    actualResults.add(minStack.getMin()+"");
                    break;
            }
        }
        System.out.println(expectedResults);
        System.out.println(actualResults);
    }
}
