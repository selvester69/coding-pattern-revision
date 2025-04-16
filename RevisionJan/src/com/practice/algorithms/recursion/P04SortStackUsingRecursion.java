package com.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P04SortStackUsingRecursion {

    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;// base case
        // hypothesis
        int el = stack.pop();
        sortStack(stack);
        // induction
        insertAtCorrectPosition(stack, el);
    }

    public void insertAtCorrectPosition(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        if (element > stack.peek()) {
            stack.push(element);
            return;
        }
        List<Integer> temp = new ArrayList<>();
        while (!stack.isEmpty() && stack.peek() > element) {
            temp.add(stack.pop());
        }
        stack.push(element);
        while (temp.size() > 0) {
            stack.push(temp.removeLast());
        }
    }

    public static void main(String[] args) {
        P04SortStackUsingRecursion obj = new P04SortStackUsingRecursion();
        Stack<Integer> st = new Stack<>();
        st.addAll(Arrays.asList(new Integer[] { 1, 4, 3, 5, 2 }));
        System.out.println(st);
        obj.sortStack(st);
        System.out.println(st);
    }

}
