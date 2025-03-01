package com.practice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Construct Smallest Number From DI String
public class Leetcode2375 {

    // naive approach using backtracking
    public static String smallestNumber_backtrackSolution(String pattern) {
        int n = pattern.length();
        boolean[] visited = new boolean[10];
        Arrays.fill(visited, false);
        char[] nums = new char[n + 1];
        if (backtrack(pattern, nums, visited, 0)) {
            return new String(nums);
        } else {
            return "";
        }

    }

    static boolean backtrack(String pattern, char[] nums, boolean[] used, int index) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                if (index == 0 ||
                (pattern.charAt(index - 1) == 'I' && nums[index - 1] < ('0' + i)) ||
                (pattern.charAt(index - 1) == 'D' && nums[index - 1] > ('0' + i))) {
                    nums[index] = (char) ('0' + i);
                    // System.out.println("----->"+new String(nums));
                    used[i] = true;
                    if (backtrack(pattern, nums, used, index + 1)) {
                        return true;
                    }
                    used[i] = false;
                }
            }
        }
        return false;
    }

    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuffer result = new StringBuffer();
        List<Integer> stack = new ArrayList<>();
    
        for (int i = 0; i <= n; i++) {
          stack.add(i + 1); // Push 1 to 9 into the stack
    
          // If it's the last index or we see 'I', pop everything from the stack
          if (i == n || pattern.charAt(i) == 'I') {
            while (!stack.isEmpty()) {
              result.append(stack.removeLast());
            }
          }
        }
        return result.toString();
      }


    public static void main(String[] args) {
        System.out.println(smallestNumber_backtrackSolution("IIIDIDDD"));
        System.out.println(smallestNumber("IIIDIDDD"));
    }

}
