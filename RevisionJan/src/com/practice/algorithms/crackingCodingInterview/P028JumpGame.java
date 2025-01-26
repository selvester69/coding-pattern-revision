package com.practice.algorithms.crackingCodingInterview;

//questions asks if we are able to go to last index 
public class P028JumpGame {

    // there are 2 ways to solve
    // either by topdown approach
    // or Bottom up approach
    public static boolean canJump_forwardLoop(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }

    public static boolean canJump_reverseLoop(int[] nums) {
        int goodIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goodIndex) {// this means i which is previous to good index is also good index
                goodIndex = i;
            }
        }
        if (goodIndex == 0) {// we have reached at the start
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + (canJump_forwardLoop(new int[] { 2, 3, 1, 1, 4 }) == true));
        System.out.println("Test Case 2: " + (canJump_forwardLoop(new int[] { 3, 2, 1, 0, 4 }) == false));
        System.out.println("Test Case 3: " + (canJump_forwardLoop(new int[] { 0 }) == true));
        System.out.println("Test Case 4: " + (canJump_forwardLoop(new int[] { 2, 0, 0 }) == true));
        System.out.println("Test Case 5: " + (canJump_forwardLoop(new int[] { 1, 1, 0, 1 }) == false));
        System.out.println("Test Case 6: " + (canJump_forwardLoop(new int[] { 10, 1, 1, 1, 1 }) == true));
        System.out.println("Test Case 7: " + (canJump_forwardLoop(new int[] { 2, 5, 0, 0 }) == true));

        System.out.println("reverse jump test case ");
        System.out.println("Test Case 1: " + (canJump_reverseLoop(new int[] { 2, 3, 1, 1, 4 }) == true));
        System.out.println("Test Case 2: " + (canJump_reverseLoop(new int[] { 3, 2, 1, 0, 4 }) == false));
        System.out.println("Test Case 3: " + (canJump_reverseLoop(new int[] { 0 }) == true));
        System.out.println("Test Case 4: " + (canJump_reverseLoop(new int[] { 2, 0, 0 }) == true));
        System.out.println("Test Case 5: " + (canJump_reverseLoop(new int[] { 1, 1, 0, 1 }) == false));
        System.out.println("Test Case 6: " + (canJump_reverseLoop(new int[] { 10, 1, 1, 1, 1 }) == true));
        System.out.println("Test Case 7: " + (canJump_reverseLoop(new int[] { 2, 5, 0, 0 }) == true));
    }

}
