package leetcode.array;

import java.util.Arrays;

public class P21ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(P21ThreeSumClosest.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));
        System.out.println(P21ThreeSumClosest.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
        System.out.println(P21ThreeSumClosest.threeSumClosest(new int[] { 0, 0, 0 }, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < minDiff) {
                    minDiff = Math.abs(target - sum);
                    closest = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }

            }
        }
        return closest;
    }

    public static int threeSumClosestBruteForce(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        if (nums.length < 3)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < minDiff) {
                        minDiff = Math.abs(target - sum);
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }
}
