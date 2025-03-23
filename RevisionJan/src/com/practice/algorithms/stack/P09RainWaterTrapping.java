package com.practice.algorithms.stack;

public class P09RainWaterTrapping {

    public int trap_bruteForce(int[] height) {
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int left = findMax(height, 0, i);
            int right = findMax(height, i + 1, height.length - 1);
            // System.out.println(left + " " + right + " " + height[i]);
            int num = Math.min(left, right) - height[i];
            if (num > 0) {
                total += num;
            }
        }
        return total;
    }

    private int findMax(int[] arr, int start, int end) {
        if (end <= 0 || start >= arr.length) {
            return 0;
        }
        int val = 0;
        for (int i = start; i <= end; i++) {
            val = Math.max(val, arr[i]);
        }
        return val;
    }

    public int trap_optimize(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightmax = new int[n];
        leftMax[0] = height[0];
        rightmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Math.min(leftMax[i], rightmax[i]) - height[i] > 0) {
                count += Math.min(leftMax[i], rightmax[i]) - height[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        P09RainWaterTrapping obj = new P09RainWaterTrapping();
        System.err.println(obj.trap_bruteForce(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.err.println(obj.trap_optimize(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

}
