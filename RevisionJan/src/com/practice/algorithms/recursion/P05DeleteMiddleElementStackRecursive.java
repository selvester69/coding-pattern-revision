package com.practice.algorithms.recursion;

import java.util.Arrays;
import java.util.Stack;

public class P05DeleteMiddleElementStackRecursive {

    public void deleteMiddle(Stack<Integer> stack, int size) {
        recursive(stack, size / 2);
    }

    public void recursive(Stack<Integer> stack, int middle) {
        if (stack.size() == 0 || middle == 0) {
            stack.pop();
            return;
        }
        int el = stack.pop();
        recursive(stack, --middle);

        stack.push(el);
    }

    public static void main(String[] args) {
        P05DeleteMiddleElementStackRecursive obj = new P05DeleteMiddleElementStackRecursive();
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(new Integer[] { 1, 4, 3, 5, 2 }));
        obj.deleteMiddle(stack, stack.size());
        System.out.println(stack);
    }

}
