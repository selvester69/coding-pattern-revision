package com.practice.algorithms.recursion;

import java.util.Arrays;
import java.util.Stack;

public class P06ReverseStackUsingRecursion {

    public void reverse(Stack<Integer> st) {
        if (st.isEmpty())
            return;
        int el = st.pop();
        reverse(st);
        insert(st, el);

    }

    public void insert(Stack<Integer> st, int el) {
        if (st.isEmpty()) {
            st.add(el);
        } else {
            int temp = st.pop();
            insert(st, el);
            st.add(temp);
        }
    }

    public static void main(String[] args) {
        P06ReverseStackUsingRecursion obj = new P06ReverseStackUsingRecursion();
        Stack<Integer> st = new Stack<>();
        st.addAll(Arrays.asList(new Integer[] { 1, 4, 3, 5, 2 }));
        System.out.println(st);
        obj.reverse(st);
        System.out.println(st);

    }

}
