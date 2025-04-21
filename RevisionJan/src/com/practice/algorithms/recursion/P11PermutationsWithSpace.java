package com.practice.algorithms.recursion;

public class P11PermutationsWithSpace {

    public void permute(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        // include
        String op1 = output + "_" + input.charAt(0);
        permute(input.substring(1), op1);
        // exclude
        String op2 = output + input.charAt(0);
        permute(input.substring(1), op2);

    }

    public static void main(String[] args) {
        P11PermutationsWithSpace obj = new P11PermutationsWithSpace();
        String s = "ABC";
        String output = "" + s.charAt(0);
        obj.permute(s.substring(1), output);
    }
}
