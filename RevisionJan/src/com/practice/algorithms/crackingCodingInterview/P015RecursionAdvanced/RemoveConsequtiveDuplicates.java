package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

import java.util.Arrays;

public class RemoveConsequtiveDuplicates {

    public static void removeDuplicates(char[] ch, int index) {
        if (ch==null || ch.length <= 1 || index >= ch.length - 1) {
            return;
        }
        if (ch[index] != ch[index + 1]) {
            removeDuplicates(ch, index + 1);
        } else {
            for (int i = index; i < ch.length-1; i++) {
                ch[i] = ch[i + 1];
            }
            removeDuplicates(ch, index);
        }
    }

    public static void main(String[] args) {
        testRemoveDuplicates(new char[]{}, new char[]{});
        testRemoveDuplicates(new char[]{'a'}, new char[]{'a'});
        testRemoveDuplicates(new char[]{'a', 'a'}, new char[]{'a'});
        testRemoveDuplicates(new char[]{'a', 'b', 'c'}, new char[]{'a', 'b', 'c'});
        testRemoveDuplicates(new char[]{'a', 'a', 'b', 'b', 'c', 'c'}, new char[]{'a', 'b', 'c'});
        testRemoveDuplicates(new char[]{'a', 'b', 'b', 'c', 'd'}, new char[]{'a', 'b', 'c', 'd'});
        testRemoveDuplicates(new char[]{'a', 'a', 'a'}, new char[]{'a'});
        testRemoveDuplicates(new char[]{'a', 'b', 'a'}, new char[]{'a', 'b', 'a'});
        testRemoveDuplicates(new char[]{'a','b','c','c','d','d','e'}, new char[]{'a','b','c','d','e'});
        testRemoveDuplicates(null, null);
        testRemoveDuplicates(new char[]{'a','a','b','b','b','c','c','c','d'}, new char[]{'a','b','c','d'});
        testRemoveDuplicates(new char[]{'a','b','c','b','c'}, new char[]{'a','b','c','b','c'});

    }

    public static void testRemoveDuplicates(char[] input, char[] expected) {
        char[] inputCopy = (input == null) ? null: Arrays.copyOf(input, input.length); // Create a copy so we don't modify the original test data
        removeDuplicates(inputCopy, 0);

        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
         if (inputCopy == null && expected == null) {
            System.out.println("Actual: null");
        } else if (inputCopy == null || expected == null || inputCopy.length != expected.length) {
            System.out.println("Actual: " + Arrays.toString(inputCopy));
        }
        else{
            boolean arraysAreEqual = true;
            for(int i=0; i<inputCopy.length; i++){
                if(inputCopy[i] != expected[i]){
                    arraysAreEqual = false;
                    break;
                }
            }
            if(arraysAreEqual){
                System.out.println("Actual: " + Arrays.toString(inputCopy));
            }
            else{
                System.out.println("Actual: " + Arrays.toString(Arrays.copyOf(inputCopy, expected.length)));
            }
        }
        System.out.println("--------------------");
    }

}
