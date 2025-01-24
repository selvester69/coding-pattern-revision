package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class PrintRecursive {

    public static void print(char[] c, int index) {
        if (c == null)
            return;
        if (index == c.length || c.length == 0)
            return;

        print(c, index + 1);
        System.out.print(c[index] + " ");
    }

    public static void main(String[] args) {
        // Redirect System.out
        // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(outContent));

        char[] emptyArray = {};
        char[] singleCharArray = { 'a' };
        char[] charArray = { 'a', 'b', 'c', 'd' };
        char[] duplicateCharArray = { 'a', 'b', 'b', 'a' };

        print(emptyArray, 0);
        System.out.println();
        // System.out.println("Test 1: Empty Array - Expected: , Actual: " +
        // outContent.toString().trim());
        // outContent.reset();

        print(singleCharArray, 0);
        System.out.println();
        // System.out.println("Test 2: Single Char Array - Expected: a, Actual: " +
        // outContent.toString().trim());
        // outContent.reset();

        print(charArray, 0);
        System.out.println();
        // System.out.println("Test 3: Char Array - Expected: d\nc\nb\na, Actual: " +
        // outContent.toString().trim());
        // outContent.reset();

        print(duplicateCharArray, 0);
        System.out.println();
        // System.out.println("Test 4: Duplicate Char Array - Expected: a\nb\nb\na,
        // Actual: " + outContent.toString().trim());
        // outContent.reset();

        print(null, 0);
        System.out.println();
        // System.out.println("Test 5: Null Array - Expected: , Actual: " +
        // outContent.toString().trim());
        // outContent.reset();

        print(charArray, 2);
        System.out.println();
        // System.out.println("Test 6: Start from middle - Expected: d\nc, Actual: " +
        // outContent.toString().trim());
        // outContent.reset();

        print(charArray, 4);
        System.out.println();
        // System.out.println("Test 7: Start from out of bound - Expected: , Actual: " +
        // outContent.toString().trim());
        // outContent.reset();

    }

}
