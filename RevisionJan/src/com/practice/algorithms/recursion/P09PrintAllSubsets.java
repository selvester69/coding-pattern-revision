package com.practice.algorithms.recursion;

//powerset , ssubset superset
// we will solve using input output method
public class P09PrintAllSubsets {

    // this is using recursion
    public void subset(String input, String output, int index) {
        if (index == input.length()) {
            System.out.println(output);
            return;
        }
        // exclude case
        subset(input, output, index + 1);
        // include case
        subset(input, output + input.charAt(index), index + 1);

    }

    public static void main(String[] args) {
        P09PrintAllSubsets obj = new P09PrintAllSubsets();
        obj.subset("abc", "", 0);
    }
}
