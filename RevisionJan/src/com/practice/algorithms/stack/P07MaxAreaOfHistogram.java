package com.practice.algorithms.stack;

// import java.util.Arrays;
import java.util.Stack;

public class P07MaxAreaOfHistogram {
    /**
     * Solution 1
     * 
     * @param heights
     * @return
     */
    // this is O(N^2) solution
    public int maxAreaHistogram_bruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];

            // traverse left
            for (int j = i - 1; j >= 0 && (heights[j] >= heights[i]); j--) {
                curr += heights[i]; // adding height i because we need minimum of the two
            }
            // traverse right
            for (int j = i + 1; j < heights.length && (heights[j] >= heights[i]); j++) {
                curr += heights[i];// adding height i because we need minimum of the two
            }
            maxArea = Math.max(curr, maxArea);
        }
        return maxArea;
    }

    /**
     * Solution 2 using 2 stack for NSR and NSL
     * 
     * @param heigths
     * @return
     */
    public int maxHistogram(int[] heigths) {
        int maxArea = 0;
        int[] nsr = NSR(heigths);
        // System.out.println(Arrays.toString(nsr));
        int[] nsl = NSL(heigths);
        // System.out.println(Arrays.toString(nsl));
        int[] ans = new int[heigths.length];
        for (int i = 0; i < heigths.length; i++) {
            ans[i] = heigths[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(maxArea, ans[i]);
        }

        return maxArea;
    }

    public int[] NSR(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<int[]> st = new Stack<int[]>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()[0] >= heights[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? heights.length : st.peek()[1];
            st.push(new int[] { heights[i], i });
        }
        return ans;
    }

    public int[] NSL(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<int[]> st = new Stack<int[]>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && st.peek()[0] >= heights[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek()[1];
            st.push(new int[] { heights[i], i });
        }
        return ans;
    }

    /**
     * Solution 3 using single stack
     * 
     * @param args
     */
    public int maxAreaHistogram_SingleStack(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int curr = 0, tp = 0, res = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                tp = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                res = Math.max(res, width * heights[tp]);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            tp = st.pop();
            curr = tp * (st.isEmpty() ? n : n - st.peek() - 1);
            res = Math.max(res, curr);
        }
        return res;
    }

    public static void main(String[] args) {
        P07MaxAreaOfHistogram obj = new P07MaxAreaOfHistogram();
        System.out.println(obj.maxHistogram(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(obj.maxAreaHistogram_bruteForce(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(obj.maxAreaHistogram_SingleStack(new int[] { 2, 1, 5, 6, 2, 3 }));
    }

}
