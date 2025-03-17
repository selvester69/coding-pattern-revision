package com.practice.algorithms.stack;

import java.util.Arrays;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P03NearestGreaterToLeft {

    public int[] ngl_bruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    public int[] ngl_stack(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 2, 0 };
        P03NearestGreaterToLeft obj = new P03NearestGreaterToLeft();
        System.out.println(Arrays.toString(obj.ngl_bruteForce(nums)));
        System.out.println(Arrays.toString(obj.ngl_stack(nums)));
    }

}
