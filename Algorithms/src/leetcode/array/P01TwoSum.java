package leetcode.array;

import java.util.*;

public class P01TwoSum {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    // O(N^2 time and O(1) space)
    public int[] twoSumBruteForce(int[] nums, int target) {
        int res[] = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
    //O(N) time  and O(N) space
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put((nums[i]), i);
            }
        }
        return res;
    }
}
