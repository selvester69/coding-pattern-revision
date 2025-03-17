package com.practice.algorithms.stack;

import java.util.Arrays;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P04NearestSmallerToLeft {

    public int[] nsl_bruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = -1;
        for (int i = 1; i < n; i++) {
            ans[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    public int[] nsl_stack(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        P04NearestSmallerToLeft obj = new P04NearestSmallerToLeft();
        System.out.println(Arrays.toString(obj.nsl_bruteForce(new int[] { 1, 6, 4, 10, 2, 5 })));
        // {-1, 1, 1, 4, 1, 2}
    }
}
