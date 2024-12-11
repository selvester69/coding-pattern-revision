package leetcode.array;

import java.util.Arrays;

public class P24SlidingWindowSum {

    public static void main(String[] args) {
        int res[] = P24SlidingWindowSum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int maxArr[] = new int[nums.length - k+1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i+1; j < i+k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxArr[i] = max;
        }
        return maxArr;
    }
}
