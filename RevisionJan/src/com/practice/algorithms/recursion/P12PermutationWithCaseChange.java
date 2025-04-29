package com.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

// input string given is in lower case only 
public class P12PermutationWithCaseChange {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        String op = "";
        permute(s, op, res);
        return res;
    }

    public void permute(String input, String output, List<String> res) {
        if (input.length() == 0) {
            res.add(output);
            return;
        }
        // lower case
        String op1 = output + (input.charAt(0) + "");
        permute(input.substring(1), op1, res);
        // uppercase
        String op2 = output + (input.charAt(0) + "").toUpperCase();
        permute(input.substring(1), op2, res);
    }

    /**
     * another way to solve the problem
     * 
     * @param args
     */
    public List<String> letterCasePermutation_2(String s) {
        List<String> res = new ArrayList<>();
        permute_2(s.toCharArray(), 0, res);
        return res;
    }

    public void permute_2(char[] input, int index, List<String> res) {
        if (index == input.length) {
            res.add(new String(input));
            return;
        }
        // lower case
        permute_2(input, index + 1, res);// lower case by default

        // upper case.
        input[index] = Character.toUpperCase(input[index]);
        permute_2(input, index + 1, res);
        input[index] = Character.toLowerCase(input[index]);// convert back

    }

    public static void main(String[] args) {
        P12PermutationWithCaseChange obj = new P12PermutationWithCaseChange();
        System.out.println(obj.letterCasePermutation("abc"));
        System.out.println(obj.letterCasePermutation_2("abc"));
    }
}
