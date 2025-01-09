package com.practice.algorithms.scottbarett.stackQueue;

public class ReverseStringStack extends Stack<Character> {

    public static void main(String[] args) {
        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);
    }

    private static String reverseString(String myString) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<myString.length();i++){
            st.push(myString.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }

}
