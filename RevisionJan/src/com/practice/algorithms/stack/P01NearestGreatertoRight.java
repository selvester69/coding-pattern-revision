package com.practice.algorithms.stack;

import java.util.Arrays;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class P01NearestGreatertoRight {

    //leetcode easy question next greater elemen part 1
    public int[] nextGreaterElement_leetcode(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }
            if(index==-1) continue;
            while (index < nums2.length) {
                if (nums2[index] > nums1[i]) {
                    ans[i] = nums2[index];
                    break;
                }
                index++;
            }
        }
        return ans;
    }

    public int[] NGR_geeks_bruteForce(int nums[]) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ngr = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ngr = nums[j];
                    break;
                }
            }
            ans[i] = ngr;
        }
        return ans;
    }

    public int[] NGR_geeks_optimized(int[] nums) {
        int[] ans = new int[nums.length];
        int index = ans.length - 1;
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[index--] = -1;
            } else if (!st.isEmpty() && st.peek() > nums[i]) {
                ans[index--] = st.peek();
            } else if (!st.isEmpty() && st.peek() <= nums[i]) {
                while (!st.isEmpty() && st.peek() <= nums[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    ans[index--] = -1;
                } else {
                    ans[index--] = st.peek();
                }
            }
            st.push(nums[i]);
        }
        return ans;
    }

    public int[] NGR_geeks_optimized_readable(int[] nums) {
        int[] ans = new int[nums.length];
        int index = ans.length - 1;
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[index--] = -1;
            } else {
                ans[index--] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
    
    public int[] test(int[] nums) {
        int[] ans = new int[nums.length];
        int index = ans.length - 1;
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        P01NearestGreatertoRight obj = new P01NearestGreatertoRight();
        // System.out.println(
        //         Arrays.toString(obj.nextGreaterElement_leetcode(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
        // System.out.println(
        //         Arrays.toString(obj.nextGreaterElement_leetcode(new int[] { 2,4 }, new int[] {1,2,3,4 })));

        //System.out.println(Arrays.toString(obj.NGR_geeks_bruteForce(new int[] { 1, 3, 4, 2 })));
        //System.out.println(Arrays.toString(obj.NGR_geeks_optimized(new int[] { 1, 3, 4, 2 })));
        System.out.println(Arrays.toString(obj.NGR_geeks_optimized_readable(new int[] { 1, 3, 4, 2 })));
        System.out.println(Arrays.toString(obj.test(new int[] { 1, 3, 4, 2 })));
        // output: [-1,3,-1]
    }
}
