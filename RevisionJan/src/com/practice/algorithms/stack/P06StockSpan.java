package com.practice.algorithms.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P06StockSpan {
    List<Integer> arr;// brute force

    Stack<int[]> st;// optimized
    int index;

    public P06StockSpan() {
        // brute force
        arr = new ArrayList<>();
        // optimized
        st = new Stack<>();
        index = -1;
    }

    public int next_bruteForce(int price) {
        int ans = 1;
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (price >= arr.get(i)) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    public int next_optimized(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        index++;
        int ans = st.isEmpty()? index+1: index - st.peek()[1];
        st.push(new int[] { price, index });

        return ans;
    }

    public int[] span_bruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {// or i can go from n-1 -> 0;
            ans[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    ans[i] = i - j;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 100, 80, 60, 70, 60, 75, 85 };
        P06StockSpan obj = new P06StockSpan();
        System.out.println("Leet code solution");
        for (int ip : input) {
            System.out.print(obj.next_optimized(ip) + " ");
        }
        
        System.out.println("\nnormal solution");
        System.out.println(Arrays.toString(
                obj.span_bruteForce(new int[] { 100, 80, 60, 70, 60, 75, 85 })));// [1, 1, 1, 2, 1, 4, 6]
    }

}
