package com.practice.algorithms.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P04MaximumOfAllSubArrays {

    public int[] maxSlidingWindow_brute(int[] nums, int k) {
        int maxArr[] = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxArr[i] = max;
        }
        return maxArr;
    }

    // using dequeue is more efficient than priority queue.

    // using sliding window
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxArr[] = new int[nums.length - k + 1];
        int index = 0;
        int i = 0, j = 0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        while (j < nums.length) {
            // do calculations
            // before adding to the list we remove all elements smaller than nums[j]
            while (dq.size() > 0 && dq.peekLast() < nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(nums[j]);
            // meet the window size
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {// window size met.
                // get ans from calculations
                maxArr[index++] = dq.peek();
                // remove nums[i] from calculations.
                if (dq.peekFirst() == nums[i]) {
                    dq.pollFirst();
                }
                // slide the window.
                i++;
                j++;
            }
        }
        return maxArr;
    }

    public static void main(String[] args) {
        P04MaximumOfAllSubArrays obj = new P04MaximumOfAllSubArrays();
        // System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[] { 9, 11 },
        // 2)));
        System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[] { 1, 3, 1, 2, 0, 5 }, 3)));
    }
}
