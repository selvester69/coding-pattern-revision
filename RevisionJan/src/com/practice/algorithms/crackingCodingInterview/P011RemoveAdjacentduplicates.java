package com.practice.algorithms.crackingCodingInterview;

import java.util.Stack;

public class P011RemoveAdjacentduplicates {

    // runtime 37 ms 
    public static String removeDuplicates_Approach1(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==c){
                    st.pop();
                continue;
            }else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    //runtime 4 ms
    public static String removeDuplicates(String s) {
        char[]ch = s.toCharArray();
        int ptr = -1;
        for(int i =0;i<ch.length;i++){
            if(ptr == -1 || ch[ptr]!=ch[i]){
                ptr++;
                ch[ptr] = ch[i];
            }else {
                ptr--;
            }
        }
        return new String(ch, 0, ptr+1);
    }



    public static void main(String[] args) {

        System.out.println("Test 1: \"abbaca\" - Expected: \"ca\", Actual: \"" + removeDuplicates("abbaca") + "\"");
        System.out.println("Test 2: \"azxxzy\" - Expected: \"ay\", Actual: \"" + removeDuplicates("azxxzy") + "\"");
        System.out.println("Test 3: \"aaaaaaaa\" - Expected: \"\", Actual: \"" + removeDuplicates("aaaaaaaa") + "\"");
        System.out.println("Test 4: \"a\" - Expected: \"a\", Actual: \"" + removeDuplicates("a") + "\"");
        System.out.println("Test 5: \"\" - Expected: \"\", Actual: \"" + removeDuplicates("") + "\"");
        System.out.println("Test 6: \"pbbcggttciiippooaais\" - Expected: \"ps\", Actual: \"" + removeDuplicates("pbbcggttciiippooaais") + "\"");
        System.out.println("Test 7: \"ibfjcaxxcckjbrxxtribf\" - Expected: \"ibfjckjbrtribf\", Actual: \"" + removeDuplicates("ibfjcaxxcckjbrxxtribf") + "\"");

    }

}
