package com.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
/**
 * same as previous problem but only 2 minor change 
 * 1. input string can be any case 
 * 2. digits are included
 */
public class P13LetterCaseChangePermutations {

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
        if (Character.isDigit(input.charAt(0))) {
            output += input.charAt(0);
            permute(input.substring(1), output, res);
            return;
        }
        // lower case
        String op2 = output + (input.charAt(0) + "").toLowerCase();
        String op1 = output + (input.charAt(0) + "").toUpperCase();
        System.out.println("op1=" + op1 + ", op2=" + op2);
        permute(input.substring(1), op2, res);
        // uppercase
        permute(input.substring(1), op1, res);
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
        if (Character.isLetter(input[index])) {
            if (Character.isUpperCase(input[index])) {
                input[index] = Character.toLowerCase(input[index]);
                permute_2(input, index + 1, res);
                input[index] = Character.toUpperCase(input[index]);// convert back
            } else {
                input[index] = Character.toUpperCase(input[index]);
                permute_2(input, index + 1, res);
                input[index] = Character.toLowerCase(input[index]);// convert back
            }
        }
        permute_2(input, index + 1, res);
    }

    public static void main(String[] args) {
        P13LetterCaseChangePermutations obj = new P13LetterCaseChangePermutations();
        System.out.println(obj.letterCasePermutation("C"));
    }

}
