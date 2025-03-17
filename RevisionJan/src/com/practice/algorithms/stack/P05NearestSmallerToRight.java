package com.practice.algorithms.stack;

import java.util.Arrays;
import java.util.Stack;

public class P05NearestSmallerToRight {

    public int[] nsr_bruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    public int[] nsr_stack(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        P05NearestSmallerToRight obj = new P05NearestSmallerToRight();
        System.out.println(Arrays.toString(obj.nsr_bruteForce(new int[] { 4, 8, 5, 2, 25 })));// 2, 5, 2, -1, -1
        System.out.println(Arrays.toString(obj.nsr_stack(new int[] { 4, 8, 5, 2, 25 })));// 2, 5, 2, -1, -1
    }

}
