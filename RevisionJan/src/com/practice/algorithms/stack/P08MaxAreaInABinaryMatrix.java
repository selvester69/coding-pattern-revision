package com.practice.algorithms.stack;

import java.util.Arrays;
import java.util.Stack;

public class P08MaxAreaInABinaryMatrix {

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != '0') {
                    arr[j] += Integer.parseInt(matrix[i][j]+"");
                } else {
                    arr[j] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
            int area = maxAreaOfHistogram(arr);
            max = Math.max(max, area);
        }
        return max;
    }

    public int maxAreaOfHistogram(int[] heights) {
        int maxArea = 0;
        int[] nsr = NSR(heights);
        int[] nsl = NSL(heights);
        int[] ans = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            ans[i] = heights[i] * (nsr[i] - nsl[i] - 1);
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

    public static void main(String[] args) {
        char[][] arr = new char[][] { { '0', '1' }, { '1', '0' } };
        P08MaxAreaInABinaryMatrix obj = new P08MaxAreaInABinaryMatrix();
        System.out.println(obj.maximalRectangle(arr));
    }
}
