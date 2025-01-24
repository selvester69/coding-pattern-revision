package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class PrintAllSubsequence {

    public static void print(String input, String op, int index) {
        if (input.length() == 0 || index == input.length()) {
            System.out.println(op);
            return;
        }

        print(input, op, index + 1);
        print(input, op + input.charAt(index), index + 1);
    }

    public static void main(String[] args) {
        print("abc", "", 0);
    }

}
