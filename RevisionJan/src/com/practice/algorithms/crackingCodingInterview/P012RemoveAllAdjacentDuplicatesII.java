package com.practice.algorithms.crackingCodingInterview;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P012RemoveAllAdjacentDuplicatesII {

    //approach 1 using stack takes longer time like 30 ms 

   static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public static String removeDuplicates_approach1(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || st.peek().ch != s.charAt(i)) {
                st.push(new Pair(s.charAt(i), 1));
            } else {
                st.peek().freq++;
                if (st.peek().freq == k) {
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            Pair p = st.pop();
            for (int i = 0; i < p.freq; i++) {
                sb.append(p.ch);
            }
        }
        return sb.reverse().toString();
    }
    
    public static String removeDuplicates(String s, int k) {
        Pair[] st = new Pair[s.length()];
        int ptr = -1;
        for (int i = 0; i < s.length(); i++) {
            if (ptr==-1|| st[ptr].ch != s.charAt(i)) {
                ptr++;
                st[ptr] = new Pair(s.charAt(i), 1);
            } else {
                st[ptr].freq++;
                if (st[ptr].freq == k) {
                    ptr--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=ptr;i++){
            for (int j = 0; j < st[i].freq; j++) {
                sb.append(st[i].ch);
            }
        }
        
        return sb.toString();
    }

    //approach 2 using char array to mimic stack

    public static void main(String[] args) {

        System.out.println(
                "Test 1: \"abcd\", k = 2 - Expected: \"abcd\", Actual: \"" + removeDuplicates("abcd", 2) + "\"");
        System.out.println("Test 2: \"deeedbbcccbdaa\", k = 3 - Expected: \"aa\", Actual: \""
                + removeDuplicates("deeedbbcccbdaa", 3) + "\"");
        System.out.println("Test 3: \"pbbcggttciiippooaais\", k = 2 - Expected: \"ps\", Actual: \""
                + removeDuplicates("pbbcggttciiippooaais", 2) + "\"");
        System.out.println("Test 4: \"\" ,k = 2 - Expected: \"\", Actual: \"" + removeDuplicates("", 2) + "\"");
        System.out.println("Test 5: \"a\" ,k = 1- Expected: \"\", Actual: \"" + removeDuplicates("a", 1) + "\"");
        System.out.println(
                "Test 6: \"aaaaaaaa\" ,k = 3- Expected: \"aa\", Actual: \"" + removeDuplicates("aaaaaaaa", 3) + "\"");
        System.out.println(
                "Test 7: \"yfttttfbbbbdsssssdddddrrrrqrrrrbbbxbbczzzzzzooonnn\" ,k = 3- Expected: \"yfbdrqrbxczon\", Actual: \""
                        + removeDuplicates("yfttttfbbbbdsssssdddddrrrrqrrrrbbbxbbczzzzzzooonnn", 3) + "\"");

    }
}
