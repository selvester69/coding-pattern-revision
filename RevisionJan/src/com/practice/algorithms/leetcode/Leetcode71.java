package com.practice.algorithms.leetcode;

import java.util.Stack;

public class Leetcode71 {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c == '/' || c == '.') {
                if (sb.length() > 0) {// word is found
                    st.push(sb.toString());
                    sb.setLength(0);
                }
                st.push(c + "");
            } else {
                sb.append(c);
            }
        }
        sb.setLength(0);
        if (sb.length() == 0 && st.peek().equals("/")) {
            st.pop();
        }
        while (st.size() > 0) {
            String word = st.pop();
            if (word.matches("[a-zA-Z]*")) {
                System.out.println(word);
                sb.append(word);
            } else {
                System.out.println(word);
            }
            // while (st.peek().equals("/") || st.peek().equals(".")) {

            // }
        }

        return "";
    }

    public static void main(String[] args) {
        Leetcode71 obj = new Leetcode71();
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
        // System.out.println(obj.simplifyPath("/../"));
        // System.out.println(obj.simplifyPath("/home//foo/"));
        // System.out.println(obj.simplifyPath("/a/../../b/../c//.//"));
        // System.out.println(obj.simplifyPath("/a//b////c/d//././/.."));
        // System.out.println(obj.simplifyPath("/.../"));
        // System.out.println(obj.simplifyPath("/a/./b/c/../../d/./e/"));
        // System.out.println(obj.simplifyPath("/a/b/c/d/e/f/g/../../h/../i/./j/"));
        // System.out.println(obj.simplifyPath("/a/b/c/d/e/f/g/h/i/j/"));
        // System.out.println(obj.simplifyPath("/a/b/c/d/e/f/g/h/i/j/./k/../l/"));
        // System.out.println(obj.simplifyPath("/a/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p/q/r/s/t/u/v/w/x/y/z/"));
    }
}
