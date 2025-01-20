package com.practice.algorithms.crackingCodingInterview;

public class P008ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int number = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            number = number * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return number;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (titleToNumber("A") == 1)); // A = 1
        System.out.println("Test Case 2: " + (titleToNumber("Z") == 26)); // Z = 26
        System.out.println("Test Case 3: " + (titleToNumber("AA") == 27)); // AA = 27
        System.out.println("Test Case 4: " + (titleToNumber("AZ") == 52)); // AZ = 52
        System.out.println("Test Case 5: " + (titleToNumber("BA") == 53)); // BA = 53
        System.out.println("Test Case 6: " + (titleToNumber("ZY") == 701)); // ZY = 701
        System.out.println("Test Case 7: " + (titleToNumber("AAA") == 703)); // AAA = 703
        System.out.println("Test Case 8: " + (titleToNumber("ZZZ") == 18278)); // ZZZ = 18278
        System.out.println("Test Case 9: " + (titleToNumber("FXSHRXW") == 2147483647)); // Maximum input
        System.out.println("Test Case 10: " + (titleToNumber("AB") == 28)); // AB = 28
    }

}
