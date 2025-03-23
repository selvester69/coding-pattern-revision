package com.practice.algorithms.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P11MinStackSpaceOptimized {
    Stack<Long> st;
    long min = Integer.MAX_VALUE;

    public P11MinStackSpaceOptimized() {
        st = new Stack<>();
    }

    public void push(int val) {
        long lg = val;
        if (st.isEmpty()) {
            st.push(lg);
            min = lg;
        }
       else if (lg < min) {
            st.push((2 * lg) - min);
            min = lg;
        } else {
            st.push(lg);
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        if (st.peek() < min) {
            min = 2 * min - st.peek();
            st.pop();
        } else {
            st.pop();
        }
    }

    public int top() {
        if (st.isEmpty())
            return -1;
        long top = st.peek();
        // then the value in stack is actually a flag
        return (int)(( min > top) ? min : top);
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        P11MinStackSpaceOptimized minStack = new P11MinStackSpaceOptimized();
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
                "null",
                "2147483646",
                "null",
                "2147483646",
                "null",
                "null",
                "2147483647",
                "2147483647",
                "null",
                "-2147483648",
                "-2147483648",
                "null",
                "2147483647");
        List<String> actualResults = new ArrayList<>();
        actualResults.add(null); // For the constructor

        for (int i = 1; i < operations.size(); i++) {
            if(i==12){
                System.err.println("start debug from here");
            }
            String operation = operations.get(i);
            Integer[] value = values.get(i);

            switch (operation) {
                case "push":
                    minStack.push(value[0]);
                    actualResults.add("null");
                    break;
                case "pop":
                    minStack.pop();
                    actualResults.add("null");
                    break;
                case "top":
                    actualResults.add(minStack.st.peek() + ""); // Accessing st.peek() directly for testing
                    break;
                case "getMin":
                    actualResults.add(minStack.getMin() + "");
                    break;
            }
        }
        System.out.println(expectedResults);
        System.out.println(actualResults);
    }
}
