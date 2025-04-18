package com.practice.algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

//other variations of problem can be 
// print unique in lexicographical order
// print all subset=powerset=subsequence  are all same questions.

public class P10PrintUniqueSubsets {

    public void printUniqueSubset(String input, String output, int index, Set<String> set) {
        if (index == input.length()) {
            set.add(output);
            return;
        }
        //exclude
        printUniqueSubset(input, output, index+1, set);
        //include
        printUniqueSubset(input, output+input.charAt(index), index+1, set);
    }

    public static void main(String[] args) {
        P10PrintUniqueSubsets obj = new P10PrintUniqueSubsets();
        Set<String> set = new HashSet<>();
        obj.printUniqueSubset("aaab", "", 0, set);
        System.out.println(set);

    }

}
